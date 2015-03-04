package isa.us.es.aml.translators;

import isa.us.es.aml.model.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jdelafuente
 *
 */
public class Translator {

    private static final Logger LOG = Logger.getLogger(Translator.class.getName());
    private final IBuilder builder;

    public Translator(IBuilder builder) {
        this.builder = builder;
    }

    public IBuilder getBuilder() {
        return this.builder;
    }

    public String export(AgreementModel model) {

        this.builder.addId(model.getID());
        this.builder.addVersion(model.getVersion());
        this.builder.addResponder(model.getResponder());

        this.export(model.getMetrics(), this.builder);
        this.export(model.getAgreementTerms(), this.builder);

        if (model.getClass() == Template.class) {
            this.export(((Template) model).getCreationConstraints(), this.builder);
        }

        return this.builder.generate();
    }

    // TODO especificar excepciones
    public String export(Metric metric) {
        try {
            return this.export(metric, this.builder.getClass().newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            Translator.LOG.log(Level.WARNING, "export_Metric exception", e);
        }
        return null;
    }

    public String export(Metric metric, IBuilder builder) {
        return builder.addMetric(metric);
    }

    public String export(AgreementTerms at) {
        try {
            return this.export(at, this.builder.getClass().newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            Translator.LOG.log(Level.WARNING, "export_AgreementTerms exception", e);
        }
        return null;
    }

    public String export(AgreementTerms at, IBuilder builder) {
        return builder.addAgreementTerms(at);
    }

    public String export(Service service) {
        try {
            return this.export(service, this.builder.getClass().newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            Translator.LOG.log(Level.WARNING, "export_Service exception", e);
        }
        return null;
    }

    public String export(Service service, IBuilder builder) {
        return builder.addService(service);
    }

    public String export(Property p) {
        try {
            return this.export(p, this.builder.getClass().newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            Translator.LOG.log(Level.WARNING, "export_Property exception", e);
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
            return this.export(gt, this.builder.getClass().newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            Translator.LOG.log(Level.WARNING, "export_GuaranteeTerm exception", e);
        }
        return null;
    }

    public String export(GuaranteeTerm gt, IBuilder builder) {
        return builder.addGuaranteeTerm(gt);
    }

    public String export(CreationConstraint cc) {
        try {
            return this.export(cc, this.builder.getClass().newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            Translator.LOG.log(Level.WARNING, "export_CreationConstraint exception", e);
        }
        return null;
    }

    public String export(CreationConstraint cc, IBuilder builder) {
        return builder.addCreationConstraint(cc);
    }

    public String export(List<? extends AgreementElement> objects) {
        try {
            return this.export(objects, this.builder.getClass().newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            Translator.LOG.log(Level.WARNING, "export_AgreementElement exception", e);
        }
        return null;
    }

    public String export(List<? extends AgreementElement> objects, IBuilder builder) {
        StringBuilder sb = new StringBuilder();
        for (AgreementElement object : objects) {
            if (object instanceof Metric) {
                sb.append(this.export((Metric) object, builder)).append("\n");
            }
            if (object instanceof Property) {
                sb.append(this.export((Property) object, builder)).append("\n");
            }
            if (object instanceof GuaranteeTerm) {
                sb.append(this.export((GuaranteeTerm) object, builder)).append("\n");
            }
            if (object instanceof CreationConstraint) {
                sb.append(this.export((CreationConstraint) object, builder)).append("\n");
            }
        }
        return sb.toString();
    }
}
