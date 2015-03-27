//package es.us.isa.aml.translator;
//
//import java.util.Collection;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import es.us.isa.aml.model.AgreementElement;
//import es.us.isa.aml.model.AgreementModel;
//import es.us.isa.aml.model.AgreementTemplate;
//import es.us.isa.aml.model.AgreementTerms;
//import es.us.isa.aml.model.ConfigurationProperty;
//import es.us.isa.aml.model.CreationConstraint;
//import es.us.isa.aml.model.GuaranteeTerm;
//import es.us.isa.aml.model.Metric;
//import es.us.isa.aml.model.MonitorableProperty;
//import es.us.isa.aml.model.Property;
//import es.us.isa.aml.model.ServiceConfiguration;
//
///**
// * @author jdelafuente
// *
// */
//public class DeprecTranslator {
//
//	private static final Logger LOG = Logger.getLogger(DeprecTranslator.class
//			.getName());
//	private IBuilder builder;
//
//	public DeprecTranslator(IBuilder builder) {
//		this.builder = builder;
//	}
//
//	public IBuilder getBuilder() {
//		return builder;
//	}
//	
//	public String export(AgreementModel model) {
//		try {
//			IBuilder _builder = builder.getClass().newInstance();
//			_builder.setDocType(model.getDocType());
//			builder = _builder;
//			return export(model, builder);
//		} catch (InstantiationException | IllegalAccessException e) {
//			LOG.log(Level.WARNING, "export_Metric exception", e);
//		}
//		return null;
//
//	}
//
//	public String export(AgreementModel model, IBuilder builder) {
//		builder.addId(model.getID());
//		builder.addVersion(model.getVersion());
//		builder.addContext(model.getContext());
//
//		export(model.getContext().getMetrics().values(), builder);
//		
//		export(model.getAgreementTerms(), builder);
//
//		if (model instanceof AgreementTemplate) {
//			export(((AgreementTemplate) model).getCreationConstraints(),
//					builder);
//		}
//
//		return builder.generate();
//	}
//
//	public String export(Metric metric) {
//		try {
//			return export(metric, builder.getClass().newInstance());
//		} catch (InstantiationException | IllegalAccessException e) {
//			LOG.log(Level.WARNING, "export_Metric exception", e);
//		}
//		return null;
//	}
//
//	public String export(Metric metric, IBuilder builder) {
//		return (String) builder.addMetric(metric);
//	}
//
//	public String export(AgreementTerms at) {
//		try {
//			return export(at, builder.getClass().newInstance());
//		} catch (InstantiationException | IllegalAccessException e) {
//			LOG.log(Level.WARNING, "export_AgreementTerms exception", e);
//		}
//		return null;
//	}
//
//	public String export(AgreementTerms at, IBuilder builder) {
//		return (String) builder.addAgreementTerms(at);
//	}
//
//	public String export(ServiceConfiguration service) {
//		try {
//			return export(service, builder.getClass().newInstance());
//		} catch (InstantiationException | IllegalAccessException e) {
//			LOG.log(Level.WARNING, "export_Service exception", e);
//		}
//		return null;
//	}
//
//	public String export(ServiceConfiguration service, IBuilder builder) {
//		return (String) builder.addService(service);
//	}
//
//	public String export(Property p) {
//		try {
//			return export(p, builder.getClass().newInstance());
//		} catch (InstantiationException | IllegalAccessException e) {
//			LOG.log(Level.WARNING, "export_Property exception", e);
//		}
//		return null;
//	}
//
//	public String export(Property p, IBuilder builder) {
//		if (p instanceof ConfigurationProperty) {
//			return (String) builder.addConfigurationProperty(p);
//		} else if (p instanceof MonitorableProperty) {
//			return (String) builder.addMonitorableProperty(p);
//		} else {
//			throw new RuntimeException("unknown property type: " + p);
//		}
//	}
//
//	public String export(GuaranteeTerm gt) {
//		try {
//			return export(gt, builder.getClass().newInstance());
//		} catch (InstantiationException | IllegalAccessException e) {
//			LOG.log(Level.WARNING, "export_GuaranteeTerm exception", e);
//		}
//		return null;
//	}
//
//	public String export(GuaranteeTerm gt, IBuilder builder) {
//		return (String) builder.addGuaranteeTerm(gt);
//	}
//
//	public String export(CreationConstraint cc) {
//		try {
//			return export(cc, builder.getClass().newInstance());
//		} catch (InstantiationException | IllegalAccessException e) {
//			LOG.log(Level.WARNING, "export_CreationConstraint exception", e);
//		}
//		return null;
//	}
//
//	public String export(CreationConstraint cc, IBuilder builder) {
//		return (String) builder.addCreationConstraint(cc);
//	}
//
//	public String export(Collection<? extends AgreementElement> objects) {
//		try {
//			return export(objects, builder.getClass().newInstance());
//		} catch (InstantiationException | IllegalAccessException e) {
//			LOG.log(Level.WARNING, "export_AgreementElement exception", e);
//		}
//		return null;
//	}
//
//	public String export(Collection<? extends AgreementElement> objects,
//			IBuilder builder) {
//		StringBuilder sb = new StringBuilder();
//		for (AgreementElement object : objects) {
//			if (object instanceof Metric) {
//				sb.append(export((Metric) object, builder)).append("\n");
//			}
//			if (object instanceof Property) {
//				sb.append(export((Property) object, builder)).append("\n");
//			}
//			if (object instanceof GuaranteeTerm) {
//				sb.append(export((GuaranteeTerm) object, builder)).append("\n");
//			}
//			if (object instanceof CreationConstraint) {
//				sb.append(export((CreationConstraint) object, builder)).append(
//						"\n");
//			}
//		}
//		return sb.toString();
//	}
//
//}
