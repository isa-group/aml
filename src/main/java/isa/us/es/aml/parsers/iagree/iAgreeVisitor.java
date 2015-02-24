// Generated from C:\Users\ISA Group\Desktop\iAgree\iAgree.g4 by ANTLR 4.1
package isa.us.es.aml.parsers.iagree;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link iAgreeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface iAgreeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link iAgreeParser#listArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListArg(@NotNull iAgreeParser.ListArgContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#creationConstraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreationConstraints(@NotNull iAgreeParser.CreationConstraintsContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#global_MonitorableProperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_MonitorableProperties(@NotNull iAgreeParser.Global_MonitorablePropertiesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#agreementTerms_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreementTerms_def(@NotNull iAgreeParser.AgreementTerms_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull iAgreeParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#descriptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescriptions(@NotNull iAgreeParser.DescriptionsContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#dateFormat_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateFormat_prop(@NotNull iAgreeParser.DateFormat_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#features}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatures(@NotNull iAgreeParser.FeaturesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#grouped_guaranteeTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrouped_guaranteeTerm(@NotNull iAgreeParser.Grouped_guaranteeTermContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#datePeriod_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatePeriod_def(@NotNull iAgreeParser.DatePeriod_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#guarantee_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuarantee_def(@NotNull iAgreeParser.Guarantee_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#template_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate_def(@NotNull iAgreeParser.Template_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull iAgreeParser.IdContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#period}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeriod(@NotNull iAgreeParser.PeriodContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#compensations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensations(@NotNull iAgreeParser.CompensationsContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#agreementTerms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreementTerms(@NotNull iAgreeParser.AgreementTermsContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#cuantif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuantif(@NotNull iAgreeParser.CuantifContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull iAgreeParser.ListContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntry(@NotNull iAgreeParser.EntryContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#ag_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAg_def(@NotNull iAgreeParser.Ag_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#expirationTime_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpirationTime_prop(@NotNull iAgreeParser.ExpirationTime_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#slo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlo(@NotNull iAgreeParser.SloContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#compensationsInterval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensationsInterval(@NotNull iAgreeParser.CompensationsIntervalContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#assig_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssig_value(@NotNull iAgreeParser.Assig_valueContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(@NotNull iAgreeParser.TemplateContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#guaranteeTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuaranteeTerm(@NotNull iAgreeParser.GuaranteeTermContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#monitorableProperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonitorableProperties(@NotNull iAgreeParser.MonitorablePropertiesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(@NotNull iAgreeParser.DescriptionContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(@NotNull iAgreeParser.RangeContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#globalPeriod_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPeriod_prop(@NotNull iAgreeParser.GlobalPeriod_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#initiator_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitiator_prop(@NotNull iAgreeParser.Initiator_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#key_value_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey_value_prop(@NotNull iAgreeParser.Key_value_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#responder_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResponder_prop(@NotNull iAgreeParser.Responder_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(@NotNull iAgreeParser.FeatureContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#guaranteeTerms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuaranteeTerms(@NotNull iAgreeParser.GuaranteeTermsContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#serviceScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceScope(@NotNull iAgreeParser.ServiceScopeContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#creationConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreationConstraint(@NotNull iAgreeParser.CreationConstraintContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#agOffer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgOffer(@NotNull iAgreeParser.AgOfferContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#gmtZone_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGmtZone_prop(@NotNull iAgreeParser.GmtZone_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(@NotNull iAgreeParser.OpContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull iAgreeParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#temp_properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemp_properties(@NotNull iAgreeParser.Temp_propertiesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#period_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeriod_def(@NotNull iAgreeParser.Period_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#creationConstraints_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreationConstraints_def(@NotNull iAgreeParser.CreationConstraints_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#temporality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporality(@NotNull iAgreeParser.TemporalityContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#versionNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionNumber(@NotNull iAgreeParser.VersionNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(@NotNull iAgreeParser.UrlContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#metrics_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetrics_prop(@NotNull iAgreeParser.Metrics_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#definedPeriod_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinedPeriod_prop(@NotNull iAgreeParser.DefinedPeriod_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService(@NotNull iAgreeParser.ServiceContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#local_MonitorableProperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal_MonitorableProperties(@NotNull iAgreeParser.Local_MonitorablePropertiesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#qualifyingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifyingCondition(@NotNull iAgreeParser.QualifyingConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#compensation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensation(@NotNull iAgreeParser.CompensationContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#globalDescription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalDescription(@NotNull iAgreeParser.GlobalDescriptionContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(@NotNull iAgreeParser.OperationContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#serviceProvider_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceProvider_prop(@NotNull iAgreeParser.ServiceProvider_propContext ctx);
}