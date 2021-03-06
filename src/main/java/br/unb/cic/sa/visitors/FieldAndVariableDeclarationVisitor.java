package br.unb.cic.sa.visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import br.unb.cic.sa.model.FieldAndVariableDeclaration;
import br.unb.cic.sa.model.ModifyHandler;

/**
 * This visitor class collects relevant data about variable declaration.
 * 
 * @author Thiago Cavalcanti / Vinicius Correa / Daniella Angelos
 */
public class FieldAndVariableDeclarationVisitor extends Visitor<FieldAndVariableDeclaration> {

	@Override
	public boolean visit(VariableDeclarationStatement node) {
		for(int i = 0; i < node.fragments().size(); i++) {
			VariableDeclarationFragment fragment = (VariableDeclarationFragment)node.fragments().get(i);
			
		
			FieldAndVariableDeclaration var = new FieldAndVariableDeclaration(file, unit.getLineNumber(node.getStartPosition()),
					unit.getLineNumber(node.getStartPosition() + node.getLength()), fragment.getName().toString(),
					node.getType().toString());
			
			var.setField(false);
			
			if (node.getType().isParameterizedType()) {
				var.setParameterized(true);
				ParameterizedType pt = (ParameterizedType)node.getType();
				List<String> pmts =  new ArrayList<>();
				for(Object e : pt.typeArguments()) {
					pmts.add(e.toString());
				}
				var.setTypeParameters(pmts);
				var.setBaseType(var.getType().substring(0, var.getType().indexOf('<')));
			}
			
		
			
		
			var.setAnnotations(ModifyHandler.listAnnotations(node.modifiers()));
			this.collectedData.addValue(var);
		}
		return super.visit(node);
	}
	
	@Override
	public boolean visit(FieldDeclaration node) {
		for(int i = 0; i < node.fragments().size(); i++) {
			VariableDeclarationFragment fragment = (VariableDeclarationFragment)node.fragments().get(i);
			
		
			FieldAndVariableDeclaration var = new FieldAndVariableDeclaration(file, unit.getLineNumber(node.getStartPosition()),
					unit.getLineNumber(node.getStartPosition() + node.getLength()), fragment.getName().toString(),
					node.getType().toString());
			
			var.setField(true);
			
			if (node.getType().isParameterizedType()) {
				var.setParameterized(true);
				ParameterizedType pt = (ParameterizedType)node.getType();
				List<String> pmts =  new ArrayList<>();
				for(Object e : pt.typeArguments()) {
					pmts.add(e.toString());
				}
				var.setTypeParameters(pmts);
			}
			var.setAnnotations(ModifyHandler.listAnnotations(node.modifiers()));
			
			this.collectedData.addValue(var);
		}
		return super.visit(node);
	}
}
