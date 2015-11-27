# Agreement Management Library

AML is a library that provides the basic infrastructure to manage Service Level Agreements.
It offers support to analyze SLAs, providing a variety of document operations as consistency, compliance, 
dead terms, etc.

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/isa-group/aml?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![release](https://img.shields.io/badge/release-0.7-green.svg)](https://raw.githubusercontent.com/isa-group/aml/master/CHANGELOG.txt)
[![Stories in Progress](https://badge.waffle.io/isa-group/aml.svg?label=in%20progress&title=In%20Progress)](http://waffle.io/isa-group/aml)

[![Throughput Graph](https://graphs.waffle.io/isa-group/aml/throughput.svg)](https://waffle.io/isa-group/aml/metrics)

## Requirements

Mandatory requirements:
* [Java SE Development Kit 7 or newer](http://www.oracle.com/technetwork/es/java/javase/downloads/index.html)

Recommended: 
* [Eclipse IDE for Java EE Developers](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/marsr)
* [IBM ILOG CPLEX Optimization Studio](https://www.ibm.com/developerworks/downloads/ws/ilogcplex/)

## Documentation

Read the following user guide to know how to use this library properly. See the [Javadoc](http://isa-group.github.io/aml/doc/) for more information.

#### Document creation

First of all, you need to declare and initialize an **AgreementManager**:
```
AgreementManager manager = new AgreementManager();
```
You can pass a configuration file to the manager as a parameter. This file has to be written in JSON format.
```
{
    "defaultInputFormat": "IAGREE",
    "CSPReasoner": "CPLEX",
    "CSPWebReasonerEndpoint": "http://150.214.188.130:8080/CSPWebReasoner",
    "DLReasoner": "none",
    "ANDConstraintsBreaking" : "true" 
}
```
To create a template, an offer or an agreement, use the manager as follow:
```
AgreementModel model = manager.createAgreementTemplate("Template's content");
AgreementModel model = manager.createAgreementOffer("Offer's content");
AgreementModel model = manager.createAgreement("Agreement's content");
```
To create a template, an offer or an agreement from a file, use these methods instead:
```
AgreementModel model = manager.createAgreementTemplateFromFile("path/to/file.at");
AgreementModel model = manager.createAgreementOfferFromFile("path/to/file.ao");
AgreementModel model = manager.createAgreementFromFile("path/to/file.ag");
```
AgreementModel is a superclass that contains the following subclasses: **AgreementTemplate**, **AgreementOffer** and **Agreement**. We can cast our model to one of these three types depending on our case.

#### Saving documents

Note that when we create models, we are not registering it. So if we need to use it later, we won't be able to retrieve it.  
If you want that a model persists, you should use **register** methods.
```
manager.register(model);
```
In this case, you'll be able to retrieve your model specifying its ID. If you prefer to specify a custom name, use the following method instead:
```
manager.register("MyModel", model);
```
To create a template, an offer or an agreement from a file, use these methods instead:
```
manager.registerFromFile(file);
manager.registerFromFile("path/to/file");
```

#### Retrieving documents

To retrieve a model, simply use one of these three methods, depending on your case:
```
manager.getAgreementTemplate("MyModel");
manager.getAgreementOffer("MyModel");
manager.getAgreement("MyModel");
```

#### Derived documents

##### Generating offers from templates

Generate an offer from a template is as easy as use the method **generateAgreementOffer** from the type AgreementTemplate.
```
AgreementTemplate myTemplate = manager.createAgreementTemplateFromFile("path/to/file.at");
AgreementOffer myOffer = myTemplate.generateAgreementOffer("Consumer name");
```

##### Generating agreements from offers

In the same way, we can generate an agreement from an offer using the method **generateAgreement**:
```
AgreementOffer myOffer = manager.createAgreementOfferFromFile("path/to/file.ao");
Agreement myAgreement = myOffer.generateAgreement("Consumer name");
```

***
## Contributing

To contribute to this project, read our [development policies](https://github.com/isa-group/aml/wiki#development-policy)
***
