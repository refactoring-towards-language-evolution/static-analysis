package br.unb.cic.sa.model;

/**
 * This class maintains relevant information about 
 * the opportunities for using Switch Strings.  
 * 
 * @author Thiago Cavalcanti / Vinicius Correa
 */
public class SwitchStringOpportunities {

	private String file;
	private int startLine;
	private int endLine;
	
	public SwitchStringOpportunities(String file, int startLine, int endLine) {
		this.file = file;
		this.startLine = startLine;
		this.endLine = endLine;
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
	
	
	
}
