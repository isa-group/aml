/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
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
	 * Visit a parse tree produced by iAgreeParser#slo.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlo(@NotNull iAgreeParser.SloContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#args.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull iAgreeParser.ArgsContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#stringAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull iAgreeParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#arrayExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull iAgreeParser.ArrayExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#ag_def.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAg_def(@NotNull iAgreeParser.Ag_defContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#local_MonitorableProperties.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal_MonitorableProperties(@NotNull iAgreeParser.Local_MonitorablePropertiesContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#assigExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigExpr(@NotNull iAgreeParser.AssigExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#parExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull iAgreeParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#creationConstraint.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreationConstraint(@NotNull iAgreeParser.CreationConstraintContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#excludesExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcludesExpr(@NotNull iAgreeParser.ExcludesExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#features.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatures(@NotNull iAgreeParser.FeaturesContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#feature.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(@NotNull iAgreeParser.FeatureContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#partiesRoles_prop.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartiesRoles_prop(@NotNull iAgreeParser.PartiesRoles_propContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#compensationsInterval.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensationsInterval(@NotNull iAgreeParser.CompensationsIntervalContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#equalityExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull iAgreeParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#template.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(@NotNull iAgreeParser.TemplateContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#guaranteeTerms.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuaranteeTerms(@NotNull iAgreeParser.GuaranteeTermsContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#agOffer.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgOffer(@NotNull iAgreeParser.AgOfferContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#creationConstraints.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreationConstraints(@NotNull iAgreeParser.CreationConstraintsContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#serviceScope.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceScope(@NotNull iAgreeParser.ServiceScopeContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#atomExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull iAgreeParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#property.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(@NotNull iAgreeParser.PropertyContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#globalDescription.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalDescription(@NotNull iAgreeParser.GlobalDescriptionContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#url.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(@NotNull iAgreeParser.UrlContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#multiplicationExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull iAgreeParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#orExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull iAgreeParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#compensationElement.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensationElement(@NotNull iAgreeParser.CompensationElementContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#metric.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetric(@NotNull iAgreeParser.MetricContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#impliesExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(@NotNull iAgreeParser.ImpliesExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#guarantee_def.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuarantee_def(@NotNull iAgreeParser.Guarantee_defContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#versionNumber.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionNumber(@NotNull iAgreeParser.VersionNumberContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#array.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull iAgreeParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#arrayAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAtom(@NotNull iAgreeParser.ArrayAtomContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#andExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull iAgreeParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#global_MonitorableProperties.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_MonitorableProperties(@NotNull iAgreeParser.Global_MonitorablePropertiesContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#range.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(@NotNull iAgreeParser.RangeContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#cuantif.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuantif(@NotNull iAgreeParser.CuantifContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#localDescription.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDescription(@NotNull iAgreeParser.LocalDescriptionContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#agreementTerms.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreementTerms(@NotNull iAgreeParser.AgreementTermsContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#numberAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(@NotNull iAgreeParser.NumberAtomContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#context_prop.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContext_prop(@NotNull iAgreeParser.Context_propContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#idAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull iAgreeParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#feature_operation.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature_operation(@NotNull iAgreeParser.Feature_operationContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#metrics_prop.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetrics_prop(@NotNull iAgreeParser.Metrics_propContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#notExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull iAgreeParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#qualifyingCondition.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifyingCondition(@NotNull iAgreeParser.QualifyingConditionContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#template_def.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate_def(@NotNull iAgreeParser.Template_defContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#listExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(@NotNull iAgreeParser.ListExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#agreement.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreement(@NotNull iAgreeParser.AgreementContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#guaranteeTerm.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuaranteeTerm(@NotNull iAgreeParser.GuaranteeTermContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#list.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull iAgreeParser.ListContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#additiveExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull iAgreeParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#iffExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIffExpr(@NotNull iAgreeParser.IffExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#temp_properties.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemp_properties(@NotNull iAgreeParser.Temp_propertiesContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#booleanAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull iAgreeParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#compensation.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensation(@NotNull iAgreeParser.CompensationContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#entry.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntry(@NotNull iAgreeParser.EntryContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#relationalExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull iAgreeParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#monitorableProperties.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonitorableProperties(@NotNull iAgreeParser.MonitorablePropertiesContext ctx);

	/**
	 * Visit a parse tree produced by iAgreeParser#service.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService(@NotNull iAgreeParser.ServiceContext ctx);
}