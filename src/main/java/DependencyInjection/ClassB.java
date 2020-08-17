package DependencyInjection;

public class ClassB {
	
	private String var1;
	public String getVar1() {
		return var1;
	}
	public String getVar2() {
		return var2;
	}
	private String var2;
	
	public ClassB(String arg1) {
		var1 = "Variable1";
		var2 = "Variable2";
	}

}
