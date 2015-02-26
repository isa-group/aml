package isa.us.es.aml.translators;

import isa.us.es.aml.model.AgreementElement;
import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.model.AgreementTerms;
import isa.us.es.aml.model.ConfigurationProperty;
import isa.us.es.aml.model.CreationConstraint;
import isa.us.es.aml.model.GuaranteeTerm;
import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.MonitorableProperty;
import isa.us.es.aml.model.Property;
import isa.us.es.aml.model.Service;
import isa.us.es.aml.model.Template;

import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class Translator {

    private IBuilder builder;

    public Translator(IBuilder builder) {
        this.builder = builder;
    }

    public IBuilder getBuilder() {
        return builder;
    }

    public AgreementModel importDocument(String content) {
        // TODO Auto-generated method stub
        return null;
    }

    public String export(AgreementModel model) {

        builder.setModel(model);

        builder.addId(model.getID());
        builder.addVersion(model.getVersion());
        builder.addResponder(model.getResponder());

        export(model.getMetrics(), builder);
        export(model.getAgreementTerms(), builder);

        if (model.getClass() == Template.class) {
            export(((Template) model).getCreationConstraints(), builder);
        }

        return builder.generate();
    }

    // TODO especificar excepciones
    public String export(Metric metric) {
        try {
            return export(metric, builder.getClass().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String export(Metric metric, IBuilder builder) {
        return builder.addMetric(metric);
    }

    public String export(AgreementTerms at) {
        try {
            return export(at, builder.getClass().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String export(AgreementTerms at, IBuilder builder) {
        return builder.addAgreementTerms(at);
    }

    public String export(Service service) {
        try {
            return export(service, builder.getClass().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String export(Service service, IBuilder builder) {
        return builder.addService(service);
    }

    public String export(Property p) {
        try {
            return export(p, builder.getClass().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String export(Property p, IBuilder builder) {
        if (p instanceof ConfigurationProperty) {
            return builder.addConfigurationProperty(p);
        } else if (p instanceof MonitorableProperty) {
            return builder.addMonitorableProperty(p);
        } else {
            throw new RuntimeException("unknown property type: " + p);
        }
    }

    public String export(GuaranteeTerm gt) {
        try {
            return export(gt, builder.getClass().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String export(GuaranteeTerm gt, IBuilder builder) {
        return builder.addGuaranteeTerm(gt);
    }

    public String export(CreationConstraint cc) {
        try {
            return export(cc, builder.getClass().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String export(CreationConstraint cc, IBuilder builder) {
        return builder.addCreationConstraint(cc);
    }

    public String export(List<? extends AgreementElement> objects) {
        try {
            return export(objects, builder.getClass().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String export(List<? extends AgreementElement> objects, IBuilder builder) {
        StringBuilder sb = new StringBuilder();
        for (AgreementElement object : objects) {
            if (object instanceof Metric) {
                sb.append(export((Metric) object, builder) + "\n");
            }
            if (object instanceof Property) {
                sb.append(export((Property) object, builder) + "\n");
            }
            if (object instanceof GuaranteeTerm) {
                sb.append(export((GuaranteeTerm) object, builder) + "\n");
            }
            if (object instanceof CreationConstraint) {
                sb.append(export((CreationConstraint) object, builder) + "\n");
            }
        }
        return sb.toString();
    }
}
