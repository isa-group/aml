// Generated from C:\Users\ISA Group\Desktop\Parsers\iAgree-parser\iAgree.g4 by ANTLR 4.1
package es.us.isa.aml.parsers.agreements.iagree;
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
	 * Visit a parse tree produced by {@link iAgreeParser#slo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlo(@NotNull iAgreeParser.SloContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull iAgreeParser.ArgsContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#stringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull iAgreeParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull iAgreeParser.ArrayExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#ag_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAg_def(@NotNull iAgreeParser.Ag_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#parExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull iAgreeParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#local_MonitorableProperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal_MonitorableProperties(@NotNull iAgreeParser.Local_MonitorablePropertiesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#assigExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigExpr(@NotNull iAgreeParser.AssigExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#temporality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporality(@NotNull iAgreeParser.TemporalityContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#creationConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreationConstraint(@NotNull iAgreeParser.CreationConstraintContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#excludesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcludesExpr(@NotNull iAgreeParser.ExcludesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#features}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatures(@NotNull iAgreeParser.FeaturesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#partiesRoles_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartiesRoles_prop(@NotNull iAgreeParser.PartiesRoles_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(@NotNull iAgreeParser.FeatureContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull iAgreeParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#compensationsInterval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensationsInterval(@NotNull iAgreeParser.CompensationsIntervalContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(@NotNull iAgreeParser.TemplateContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#agOffer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgOffer(@NotNull iAgreeParser.AgOfferContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#creationConstraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreationConstraints(@NotNull iAgreeParser.CreationConstraintsContext ctx);

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
	 * Visit a parse tree produced by {@link iAgreeParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull iAgreeParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(@NotNull iAgreeParser.PropertyContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#globalDescription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalDescription(@NotNull iAgreeParser.GlobalDescriptionContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#period}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeriod(@NotNull iAgreeParser.PeriodContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull iAgreeParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(@NotNull iAgreeParser.UrlContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull iAgreeParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#compensationElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensationElement(@NotNull iAgreeParser.CompensationElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#metric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetric(@NotNull iAgreeParser.MetricContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#impliesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(@NotNull iAgreeParser.ImpliesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#guarantee_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuarantee_def(@NotNull iAgreeParser.Guarantee_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#versionNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionNumber(@NotNull iAgreeParser.VersionNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull iAgreeParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#arrayAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAtom(@NotNull iAgreeParser.ArrayAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull iAgreeParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#global_MonitorableProperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_MonitorableProperties(@NotNull iAgreeParser.Global_MonitorablePropertiesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(@NotNull iAgreeParser.RangeContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#cuantif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuantif(@NotNull iAgreeParser.CuantifContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#dateFormat_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateFormat_prop(@NotNull iAgreeParser.DateFormat_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#expirationTime_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpirationTime_prop(@NotNull iAgreeParser.ExpirationTime_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#localDescription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDescription(@NotNull iAgreeParser.LocalDescriptionContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#agreementTerms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreementTerms(@NotNull iAgreeParser.AgreementTermsContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#numberAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(@NotNull iAgreeParser.NumberAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#context_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContext_prop(@NotNull iAgreeParser.Context_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#period_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeriod_def(@NotNull iAgreeParser.Period_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#idAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull iAgreeParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#feature_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature_operation(@NotNull iAgreeParser.Feature_operationContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#metrics_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetrics_prop(@NotNull iAgreeParser.Metrics_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull iAgreeParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#qualifyingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifyingCondition(@NotNull iAgreeParser.QualifyingConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(@NotNull iAgreeParser.ListExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#template_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate_def(@NotNull iAgreeParser.Template_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#globalPeriod_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPeriod_prop(@NotNull iAgreeParser.GlobalPeriod_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#agreement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreement(@NotNull iAgreeParser.AgreementContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#guaranteeTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuaranteeTerm(@NotNull iAgreeParser.GuaranteeTermContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull iAgreeParser.ListContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull iAgreeParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#gmtZone_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGmtZone_prop(@NotNull iAgreeParser.GmtZone_propContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#iffExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIffExpr(@NotNull iAgreeParser.IffExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#temp_properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemp_properties(@NotNull iAgreeParser.Temp_propertiesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull iAgreeParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#compensation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensation(@NotNull iAgreeParser.CompensationContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull iAgreeParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntry(@NotNull iAgreeParser.EntryContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService(@NotNull iAgreeParser.ServiceContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#monitorableProperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonitorableProperties(@NotNull iAgreeParser.MonitorablePropertiesContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#datePeriod_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatePeriod_def(@NotNull iAgreeParser.DatePeriod_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link iAgreeParser#definedPeriod_prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinedPeriod_prop(@NotNull iAgreeParser.DefinedPeriod_propContext ctx);
}