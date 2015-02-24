/**
 * 
 */
package isa.us.es.aml.parsers.iagree;

import isa.us.es.aml.model.Actor;
import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.model.AgreementOffer;
import isa.us.es.aml.model.CreationConstraint;
import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.Property;
import isa.us.es.aml.model.Range;
import isa.us.es.aml.model.SLO;
import isa.us.es.aml.model.Template;
import isa.us.es.aml.model.expression.AtomicExpression;
import isa.us.es.aml.model.expression.Expression;
import isa.us.es.aml.parsers.iagree.iAgreeParser.AgOfferContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Ag_defContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.AgreementTermsContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.AgreementTerms_defContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Assig_valueContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.CompensationContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.CompensationsContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.CompensationsIntervalContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.CreationConstraintContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.CreationConstraintsContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.CreationConstraints_defContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.CuantifContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.DateFormat_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.DatePeriod_defContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.DefinedPeriod_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.DescriptionContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.DescriptionsContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.EntryContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.ExpirationTime_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.ExpressionContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.FeatureContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.FeaturesContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.GlobalDescriptionContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.GlobalPeriod_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Global_MonitorablePropertiesContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.GmtZone_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Grouped_guaranteeTermContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.GuaranteeTermContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.GuaranteeTermsContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Guarantee_defContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.IdContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Initiator_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Key_value_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.ListArgContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.ListContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Local_MonitorablePropertiesContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Metrics_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.MonitorablePropertiesContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.OpContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.OperationContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.PeriodContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Period_defContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.QualifyingConditionContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.RangeContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Responder_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.ServiceContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.ServiceProvider_propContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.ServiceScopeContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.SloContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Temp_propertiesContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.TemplateContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.Template_defContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.TemporalityContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.TypeContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.UrlContext;
import isa.us.es.aml.parsers.iagree.iAgreeParser.VersionNumberContext;
import isa.us.es.aml.util.Util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * @author jdelafuente
 *
 */
public class MiAgreeVisitor implements iAgreeVisitor<Object> {

	public AgreementModel model;
	public Map<String, Metric> metrics;
	public long timeStamp;

	@Override
	public AgreementModel visitEntry(EntryContext ctx) {
		try {
			timeStamp = Calendar.getInstance().getTimeInMillis();
			metrics = new HashMap<String, Metric>();
			
			if (ctx.template() != null) {
				model = new Template();
				visitTemplate(ctx.template());

			} else if (ctx.agOffer() != null) {
				model = new AgreementOffer();
				visitAgOffer(ctx.agOffer());
			}

		} catch (Exception e) {
			System.out.println("iAgree parsing exception catched: enterEntry");
		}

		return model;
	}

	@Override
	public Object visitTemplate(TemplateContext ctx) {
		try {
			model.setID(ctx.Identifier().getText());
			model.setVersion(new Float(ctx.versionNumber().getText()));
			
			visitTemplate_def(ctx.template_def());

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterTemplate");
		}

		return null;
	}

	@Override
	public Object visitAgOffer(AgOfferContext ctx) {
		try {
			model.setID(ctx.Identifier(0).getText());
			model.setVersion(new Float(ctx.versionNumber(0).getText()));

			((AgreementOffer) model).setTemplateId(ctx.Identifier(1).getText());
			((AgreementOffer) model).setTemplateVersion(new Float(ctx
					.versionNumber(1).getText()));

			visitAg_def(ctx.ag_def());

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterAgOffer");
		}
		return null;
	}

	@Override
	public Object visitTemplate_def(Template_defContext ctx) {
		try {
			for (Temp_propertiesContext tempCtx : ctx.temp_properties()) {
				visitTemp_properties(tempCtx);
			}

			visitAgreementTerms(ctx.agreementTerms());

			visitCreationConstraints(ctx.creationConstraints());

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterTemplate_def");
		}

		return null;
	}

	@Override
	public Object visitAg_def(Ag_defContext ctx) {
		try {
			for (Temp_propertiesContext tp : ctx.temp_properties()) {
				visitTemp_properties(tp);
			}

			visitAgreementTerms(ctx.agreementTerms());

		} catch (Exception e) {
			System.out.println("iAgree parsing exception catched: enterAg_def");
		}

		return null;
	}

	@Override
	public Object visitAgreementTerms(AgreementTermsContext ctx) {
		try {
			visitAgreementTerms_def(ctx.agreementTerms_def());
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterAgreementTerms");
		}
		return null;
	}

	@Override
	public Object visitAgreementTerms_def(AgreementTerms_defContext ctx) {
		try {
			visitService(ctx.service());

			visitMonitorableProperties(ctx.monitorableProperties());

			visitGuaranteeTerms(ctx.guaranteeTerms());

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterAgreementTerms_def");
		}
		return null;
	}

	@Override
	public Object visitCreationConstraints(CreationConstraintsContext ctx) {
		try {
			visitCreationConstraints_def(ctx.creationConstraints_def());
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterCreationConstraints");
		}

		return null;
	}

	@Override
	public Object visitCreationConstraints_def(
			CreationConstraints_defContext ctx) {
		try {
			for (CreationConstraintContext cc : ctx.creationConstraint()) {
				visitCreationConstraint(cc);
			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterCreationConstraints_def");
		}
		return null;
	}

	@Override
	public Object visitCreationConstraint(CreationConstraintContext ctx) {
		try {
//			Expression exp = visitExpression(ctx.expression());
			
			Expression exp = new AtomicExpression(ctx.expression().getText());

			SLO slo = new SLO(exp);

			CreationConstraint cc = new CreationConstraint(ctx.Identifier()
					.getText(), slo);
			
			((Template) model).getCreationConstraints().add(cc);
			
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterCreationConstraint");
		}
		return null;
	}

	@Override
	public Object visitService(ServiceContext ctx) {
		try {
			visitGlobalDescription(ctx.globalDescription());
			visitDescriptions(ctx.descriptions());

			model.getAgreementTerms()
					.getService()
					.setServiceReference(
							Util.withoutDoubleQuotes(ctx.url().getText()));

			String serviceName = ctx.Identifier().getText();

			model.getAgreementTerms().getService().setServiceName(serviceName);

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterService");
		}
		return null;
	}

	@Override
	public Object visitTemp_properties(Temp_propertiesContext ctx) {
		try {
			if (ctx.initiator_prop() != null) {

				String initiator = Util.withoutDoubleQuotes(ctx
						.initiator_prop().String().getText());
				model.setInitiator(initiator);
			} else if (ctx.responder_prop() != null) {
				if (ctx.responder_prop().PROVIDER() != null) {

					model.setResponder(Actor.valueOf(ctx.responder_prop()
							.PROVIDER().getText()));

				} else if (ctx.responder_prop().CONSUMER() != null) {

					model.setResponder(Actor.valueOf(ctx.responder_prop()
							.CONSUMER().getText()));

				} else if (ctx.responder_prop().Identifier() != null) {

					model.setResponder(ctx.responder_prop().Identifier()
							.getText());

				}
			} else if (ctx.serviceProvider_prop() != null) {

				model.setServiceProvider(Util.withoutDoubleQuotes(ctx
						.serviceProvider_prop().String().getText()));

			} else if (ctx.expirationTime_prop() != null) {
				// TODO

			} else if (ctx.dateFormat_prop() != null) {
				// TODO Definir temporalidad

			} else if (ctx.gmtZone_prop() != null) {
				if (ctx.gmtZone_prop().S_Integer() != null) {

					// TODO
					ctx.gmtZone_prop().S_Integer().getText();

				} else if (ctx.gmtZone_prop().Integer() != null) {

					// TODO
					ctx.gmtZone_prop().Integer().getText();

				}
			} else if (ctx.globalPeriod_prop() != null) {
				// TODO Definir temporalidad

			} else if (ctx.definedPeriod_prop() != null) {
				// TODO Definir temporalidad

			} else if (ctx.metrics_prop() != null) {
				
				visitMetrics_prop(ctx.metrics_prop());

			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterTemp_properties");
		}
		return null;
	}
	
	@Override
	public Object visitMonitorableProperties(MonitorablePropertiesContext ctx) {
		try {
			if (ctx.global_MonitorableProperties() != null)
				visitGlobal_MonitorableProperties(ctx
						.global_MonitorableProperties());
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterMonitorableProperties");
		}
		return null;
	}
	
	@Override
	public Object visitGuaranteeTerms(GuaranteeTermsContext ctx) {
		try {
			for (GuaranteeTermContext gt : ctx.guaranteeTerm()) {
				visitGuaranteeTerm(gt);
			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterGuaranteeTerms");
		}
		return null;
	}
	
	@Override
	public Object visitGlobalDescription(GlobalDescriptionContext ctx) {
		try {
			for (Key_value_propContext kv : ctx.key_value_prop()) {
				Property cp = visitKey_value_prop(kv);
				//model.getAgreementTerms().getConfigurationProperties().add(cp);
			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterGlobalDescription");
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	@Override
	public Metric visitType(TypeContext ctx) {
		
		// TODO
		
		return null;
	}
	
	@Override
	public Range visitRange(RangeContext ctx) {
		Range r = null;
		try {
			r = new Range(Integer.valueOf(ctx.min.getText()), Integer.valueOf(ctx.max.getText()));
		} catch (Exception e) {
			System.out.println("iAgree parsing exception catched: enterRange");
		}
		
		return r;
	}
	
	@Override
	public Object visitMetrics_prop(Metrics_propContext ctx) {
		try {
			
			Metric bool = new Metric("boolean", "enumerated", new Range(0, 1));
			metrics.put("boolean", bool);
			
		} catch (Exception e) {
			System.out.println("iAgree parsing exception catched: enterMetrics_prop");
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Property visitKey_value_prop(Key_value_propContext ctx) {
		Property p = null;
		
		try {
			String key = ctx.k.getText();

			String value = "";
			if (ctx.v != null) {
				value = ctx.v.getText();
			} else if (ctx.v2 != null) {
				value = ctx.v2.getText();
			}			
			
			p = new Property(key, metrics.get(value));
			
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterKey_value_prop");
		}
		
		return p;
	}
	
	
	@Override
	public Expression visitExpression(ExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ParseTree tree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitChildren(RuleNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitListArg(ListArgContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGlobal_MonitorableProperties(
			Global_MonitorablePropertiesContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDescriptions(DescriptionsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDateFormat_prop(DateFormat_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFeatures(FeaturesContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGrouped_guaranteeTerm(Grouped_guaranteeTermContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDatePeriod_def(DatePeriod_defContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGuarantee_def(Guarantee_defContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitId(IdContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPeriod(PeriodContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCompensations(CompensationsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCuantif(CuantifContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitList(ListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitExpirationTime_prop(ExpirationTime_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSlo(SloContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCompensationsInterval(CompensationsIntervalContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitAssig_value(Assig_valueContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGuaranteeTerm(GuaranteeTermContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDescription(DescriptionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGlobalPeriod_prop(GlobalPeriod_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitInitiator_prop(Initiator_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitResponder_prop(Responder_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFeature(FeatureContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitServiceScope(ServiceScopeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGmtZone_prop(GmtZone_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitOp(OpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPeriod_def(Period_defContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTemporality(TemporalityContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitVersionNumber(VersionNumberContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitUrl(UrlContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDefinedPeriod_prop(DefinedPeriod_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitLocal_MonitorableProperties(
			Local_MonitorablePropertiesContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitQualifyingCondition(QualifyingConditionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCompensation(CompensationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitOperation(OperationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitServiceProvider_prop(ServiceProvider_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
