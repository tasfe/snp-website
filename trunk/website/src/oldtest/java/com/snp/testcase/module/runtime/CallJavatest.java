package com.snp.testcase.module.runtime;

public class CallJavatest {

	public static void main(String[] args) {
		try {
			Runtime
					.getRuntime()
					.exec(
							"java   -classpath   .;webroot\\WEB-INF\\classes;D:\\train\\m2\\repository\\snpsoft\\commons-logging\\1.0\\commons-logging-1.0.jar;D:\\train\\m2\\repository\\snpsoft\\commons-lang\\2.0\\commons-lang-2.0.jar; com.snp.site.update.Download");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
