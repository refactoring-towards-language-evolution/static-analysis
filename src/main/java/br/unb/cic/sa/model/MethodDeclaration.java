package br.unb.cic.sa.model;

/**
 * This class maintains relevant information about 
 * method declaration. 
 * 
 * @author Thiago Cavalcanti / Vinicius Correa
 */
public class MethodDeclaration {
	
	private String file;
	private int startLine;
	private int endLine; 
	private String name;
	private boolean varArgs;
	private boolean parameterizedMethod;
	private boolean synchronizedMethod;
	private String parameterizedType;
	private String annotations;
	private boolean defaultMethod;
	
	public MethodDeclaration(String file, int startLine, int endLine, String name){
		this.file = file;
		this.startLine = startLine;
		this.endLine = endLine;
		this.name = name;
		defaultMethod = false;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getStartLine() {
		return startLine;
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVarArgs() {
		return varArgs;
	}

	public void setVarArgs(boolean varArgs) {
		this.varArgs = varArgs;
	}

	public boolean isParameterizedMethod() {
		return parameterizedMethod;
	}

	public void setParameterizedMethod(boolean parameterizedMethod) {
		this.parameterizedMethod = parameterizedMethod;
	}

	public String getParameterizedType() {
		return parameterizedType;
	}

	public void setParameterizedType(String parameterizedType) {
		this.parameterizedType = parameterizedType;
	}
	
	public void setSynchronizedMethod(boolean synchronizedMethod) {
		this.synchronizedMethod = synchronizedMethod;
	}
	
	public boolean isSynchronizedMethod() {
		return synchronizedMethod;
	}
	
	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}
	
	public String getAnnotations() {
		return this.annotations;
	}

	public boolean isDefaultMethod() {
		return defaultMethod;
	}

	public void setDefaultMethod(boolean defaultMethod) {
		this.defaultMethod = defaultMethod;
	}
}
