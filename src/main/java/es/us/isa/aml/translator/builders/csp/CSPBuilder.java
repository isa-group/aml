package es.us.isa.aml.translator.builders.csp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.csp.CSPRange;
import es.us.isa.aml.model.csp.CSPVar;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.ListExpression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.translator.IBuilder;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class CSPBuilder implements IBuilder {

	private CSPModel model;
	private DocType docType;

	private Map<String, CSPVar> vars = new HashMap<>();

	public CSPBuilder() {
		this.model = new CSPModel();
	}

	@Override
	public void setDocType(DocType type) {
		docType = type;
	}

	@Override
	public void setContext(Context context) {
		for (Metric m : context.getMetrics().values())
			setMetric(m);
	}

	@Override
	public void setMetric(Metric metric) {
		if (this.model == null) {
			this.model = new CSPModel();
		}

		if (metric.getType().equals("enum")) {
			CSPVar domain = new CSPVar("domain_" + metric.getId(),
					metric.getType(), false);
			domain.setExpression(new ListExpression(((Enumerated) metric
					.getDomain()).getValues()));

			Integer max_size = ((Enumerated) metric.getDomain()).getValues().length;
			CSPRange range_enum = new CSPRange(domain.getId(), new Range(0,
					max_size - 1));
			CSPVar _enum = new CSPVar("enum_" + metric.getId(), "integer",
					false);
			_enum.setRange(range_enum);
			List<Integer> range = new ArrayList<Integer>();
			for (int i = 0; i < max_size; i++) {
				range.add(i);
			}
			_enum.setExpression(new ListExpression(range));
			this.model.addVar(domain);
			vars.put(domain.getId(), domain);
			this.model.addVar(_enum);
			vars.put(_enum.getId(), _enum);
		} else {
			if (metric.getId().equals("boolean"))
				return;
			CSPRange range = new CSPRange("range_" + metric.getId(),
					metric.getDomain());
			this.model.addRange(range);
		}
	}

	@Override
	public void setAgreementTerms(AgreementTerms at) {
		if (this.model == null) {
			this.model = new CSPModel();
		}

		setService(at.getService());

		for (MonitorableProperty mp : at.getMonitorableProperties().values()) {
			this.setMonitorableProperty(mp);
			;
		}

		for (GuaranteeTerm gt : at.getGuaranteeTerms().values()) {
			this.setGuaranteeTerm(gt);
		}
	}

	@Override
	public void setService(ServiceConfiguration service) {
		for (ConfigurationProperty cp : service.getConfigurationProperties()
				.values()) {
			this.setConfigurationProperty(cp);
		}
	}

	@Override
	public void setConfigurationProperty(Property cp) {
		if (this.model == null) {
			this.model = new CSPModel();
		}

		if (cp.getMetric().getType().equals("enum")) {
			CSPVar var = new CSPVar(cp.getId(), getTypeByOpt(cp.getMetric()
					.getType(), model.getUseCP()), vars.get(
					"enum_" + cp.getMetric().getId()).getRange(), true);
			this.model.addVar(var);
			vars.put(var.getId(), var);

		} else {

			Map<String, CSPRange> ranges = new HashMap<>();
			for (CSPRange range : this.model.getRanges()) {
				ranges.put(range.getId(), range);
			}

			CSPVar var = new CSPVar(cp.getId(), getTypeByOpt(cp.getMetric()
					.getType(), model.getUseCP()), ranges.get("range_"
					+ cp.getMetric().getId()), true);
			this.model.addVar(var);
			vars.put(var.getId(), var);
		}

		if (docType == DocType.OFFER) {
			if (cp.getExpression() != null) {
				String assig = "ASSIG_" + cp.getId().toString();
				for (CSPConstraint cons : model.getConstraints()) {
					if (cons.getId().contains("ASSIG")) {
						assig = "ASSIG_" + cp.getId().toString();
					}
				}

				if (cp.getMetric().getType().equals("enum")) {
					Expression exp = new Atomic("enum_"
							+ cp.getMetric().getId()
							+ "["
							+ "\""
							+ Util.withoutDoubleQuotes(cp.getExpression()
									.toString()) + "\"" + "]");
					Expression expr = new RelationalExpression(new Var(cp),
							exp, RelationalOperator.EQ);
					CSPConstraint constraint = new CSPConstraint(assig, expr);
					this.model.addConstraint(constraint);
				} else {
					Expression expr = new RelationalExpression(new Var(cp),
							cp.getExpression(), RelationalOperator.EQ);
					CSPConstraint constraint = new CSPConstraint(assig, expr);
					this.model.addConstraint(constraint);
				}
			}
		}
	}

	@Override
	public void setMonitorableProperty(Property mp) {
		if (this.model == null) {
			this.model = new CSPModel();
		}

		if (mp.getMetric().getType().equals("enum")) {
			CSPVar var = new CSPVar(mp.getId(), getTypeByOpt(mp.getMetric()
					.getType(), model.getUseCP()), vars.get(
					"enum_" + mp.getMetric().getId()).getRange(), true);
			this.model.addVar(var);
			vars.put(var.getId(), var);

		} else {

			Map<String, CSPRange> ranges = new HashMap<>();
			for (CSPRange range : this.model.getRanges()) {
				ranges.put(range.getId(), range);
			}

			CSPVar var = new CSPVar(mp.getId(), getTypeByOpt(mp.getMetric()
					.getType(), model.getUseCP()), ranges.get("range_"
					+ mp.getMetric().getId()), true);
			this.model.addVar(var);
			vars.put(var.getId(), var);
		}

		if (docType == DocType.OFFER) {
			if (mp.getExpression() != null) {
				/*
				int i = 1;
				String assig = "ASSIG";
				for (CSPConstraint cons : model.getConstraints()) {
					if (cons.getId().contains("ASSIG")) {
						i++;
					}
				}
				assig = "ASSIG_" + i;
				*/
				String assig = "ASSIG_" + mp.getId().toString();
				for (CSPConstraint cons : model.getConstraints()) {
					if (cons.getId().contains("ASSIG")) {
						assig = "ASSIG_" + mp.getId().toString();
					}
				}
				if (mp.getMetric().getType().equals("enum")) {
					Expression exp = new Atomic("enum_"
							+ mp.getMetric().getId() + "[" + mp.getExpression()
							+ "]");
					Expression expr = new RelationalExpression(new Var(mp),
							exp, RelationalOperator.EQ);
					CSPConstraint constraint = new CSPConstraint(assig, expr);
					this.model.addConstraint(constraint);
				} else {
					Expression expr = new RelationalExpression(new Var(mp),
							mp.getExpression(), RelationalOperator.EQ);
					CSPConstraint constraint = new CSPConstraint(assig, expr);
					this.model.addConstraint(constraint);
				}
			}
		}
	}

	@Override
	public void setGuaranteeTerm(GuaranteeTerm gt) {
		try {
			if (this.model == null) {
				this.model = new CSPModel();
			}

			GuaranteeTerm gt_clon = gt.clone();

			Expression expr_slo = gt_clon.getSlo().getExpression();
			List<Expression> expressions = Expression
					.splitExpressions(expr_slo);
			for (Expression expr : expressions) {
				for (Var v : Expression.getVars(expr)) {
					if (vars.containsKey(v.getId())) {
						CSPVar var = vars.get(v.getId());
						if (var.getType().equals("{string}")) {
							for (Atomic atom : Expression.getAtomics(expr)) {
								if (atom.calculate() instanceof String) {
									String range_id = var.getRange().getId()
											.split("domain_")[1];
									Expression ex = new Atomic("enum_"
											+ range_id + "[" + atom + "]");
									atom.setValue(ex);
								}
							}
						}
					}
				}
			}

			if (gt.getQc() != null) {
				Expression expr_qc = gt_clon.getQc().getCondition();
				List<Expression> expressions_qc = Expression
						.splitExpressions(expr_qc);
				for (Expression expr : expressions_qc) {
					for (Var v : Expression.getVars(expr)) {
						if (vars.containsKey(v.getId())) {
							CSPVar var = vars.get(v.getId());
							if (var.getType().equals("{string}")) {
								for (Atomic atom : Expression.getAtomics(expr)) {
									if (atom.calculate() instanceof String) {
										String range_id = var.getRange()
												.getId().split("domain_")[1];
										Expression ex = new Atomic("enum_"
												+ range_id + "[" + atom + "]");
										atom.setValue(ex);
									}
								}
							}
						}
					}
				}
			}

			if (Boolean.valueOf(Config.getProperty("ANDConstraintsBreaking"))) {
				List<Expression> expressions_slo = Expression
						.splitANDExpressions(expr_slo);
				Integer i = 1;
				for (Expression exp : expressions_slo) {
					String id = (expressions.size() > 1) ? gt.getId() + "_" + i
							: gt.getId();
					CSPConstraint cons = null;
					if (gt.getQc() != null)
						cons = new CSPConstraint(id, new SLO(exp),
								gt_clon.getQc());
					else
						cons = new CSPConstraint(id, new SLO(exp));

					if (cons != null)
						this.model.addConstraint(cons);

					i++;
				}
			} else {
				CSPConstraint cons = null;
				if (gt.getQc() != null)
					cons = new CSPConstraint(gt.getId(), gt_clon.getSlo(),
							gt_clon.getQc());
				else
					cons = new CSPConstraint(gt.getId(), gt_clon.getSlo());

				if (cons != null)
					this.model.addConstraint(cons);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setCreationConstraint(CreationConstraint cc) {
		if (this.model == null) {
			this.model = new CSPModel();
		}

		CSPConstraint cons = null;
		CreationConstraint cc_clon = cc.clone();
		Expression expr_slo = cc_clon.getSlo().getExpression();
		List<Expression> expressions = Expression.splitExpressions(expr_slo);

		for (Expression expr : expressions) {
			for (Var v : Expression.getVars(expr)) {
				if (vars.containsKey(v.getId())) {
					CSPVar var = vars.get(v.getId());
					if (var.getType().equals("{string}")) {
						for (Atomic atom : Expression.getAtomics(expr)) {
							if (atom.calculate() instanceof String) {
								String range_id = var.getRange().getId()
										.split("domain_")[1];
								Expression ex = new Atomic("enum_" + range_id
										+ "[" + atom + "]");
								atom.setValue(ex);
							}
						}
					}
				}
			}
		}

		if (cc.getQc() != null) {
			Expression expr_qc = cc_clon.getQc().getCondition();

			List<Expression> expressions_qc = Expression
					.splitExpressions(expr_qc);

			for (Expression expr : expressions_qc) {
				for (Var v : Expression.getVars(expr)) {
					if (vars.containsKey(v.getId())) {
						CSPVar var = vars.get(v.getId());
						if (var.getType().equals("{string}")) {
							for (Atomic atom : Expression.getAtomics(expr)) {
								if (atom.calculate() instanceof String) {
									String range_id = var.getRange().getId()
											.split("domain_")[1];
									Expression ex = new Atomic("enum_"
											+ range_id + "[" + atom + "]");
									atom.setValue(ex);
								}
							}
						}
					}
				}
			}
		}

		if (cc.getQc() != null)
			cons = new CSPConstraint(cc.getId(), cc_clon.getSlo(),
					cc_clon.getQc());
		else
			cons = new CSPConstraint(cc.getId(), cc_clon.getSlo());

		this.model.addConstraint(cons);
	}

	@Override
	public String generate() {
		return this.model.toString();
	}

	@Override
	public CSPModel getModel() {
		return model;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVersion(Double version) {
		// TODO Auto-generated method stub

	}

	public String getTypeByOpt(String originalType, Boolean useCP) {
		if (originalType.equals("real") || originalType.equals("float"))
			return "int";
		return originalType;
	}
}
