package mk.ukim.finki.wp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {
	public static void main(String[] args) throws IOException {
		String basePackage = Generator.class.getPackage().getName();
		File basePath = new File("src/main/java/"
				+ basePackage.replaceAll("\\.", "/"));

		File baseRepository = new File(basePath, "repository");
		File baseService = new File(basePath, "service");
		File baseServiceImpl = new File(basePath, "service/impl");
		File baseResource = new File(basePath, "web/rest");

		String tplRepository = readFile(basePath, "repository.txt");
		String tplService = readFile(basePath, "service.txt");
		String tplServiceImpl = readFile(basePath, "serviceImpl.txt");
		String tplResource = readFile(basePath, "resource.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(new File("db")));
		String line = new String();
		
		while ((line = br.readLine()) != null) {
			System.out.println("Enter entity subpackage: {base}.model.{?}");
			String modelPackage = "db";
			
			System.out.println("Enter entity class name: ");
			String modelClassName = line;

			System.out.println("Enter rest path /rest/data/{path}: ");
			String restPath = line;

			File repositoryDir = new File(baseRepository, modelPackage);
			if (!repositoryDir.exists()) {
				repositoryDir.mkdirs();
			}
			createRepository(repositoryDir, tplRepository, modelPackage,
					modelClassName);

			File serviceDir = new File(baseService, modelPackage);
			if (!serviceDir.exists()) {
				serviceDir.mkdirs();
			}
			createService(serviceDir, tplService, modelPackage, modelClassName);

			File serviceImplDir = new File(baseServiceImpl, modelPackage);
			if (!serviceImplDir.exists()) {
				serviceImplDir.mkdirs();
			}
			createServiceImpl(serviceImplDir, tplServiceImpl, modelPackage,
					modelClassName);

			File resourceDir = new File(baseResource, modelPackage);
			if (!resourceDir.exists()) {
				resourceDir.mkdirs();
			}
			createResource(resourceDir, tplResource, modelPackage,
					modelClassName, restPath);
		}
		
		br.close();
		
	}

	private static String readFile(File base, String name) {
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(base, name)));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		return sb.toString();
	}

	private static void createRepository(File dir, String tpl,
			String modelPackage, String modelClassName) {
		File file = new File(dir, modelClassName + "Repository.java");
		writeTemplate(file, tpl, modelPackage, modelClassName);
	}

	private static void createService(File dir, String tpl,
			String modelPackage, String modelClassName) {
		File file = new File(dir, modelClassName + "Service.java");
		writeTemplate(file, tpl, modelPackage, modelClassName);

	}

	private static void createServiceImpl(File dir, String tpl,
			String modelPackage, String modelClassName) {
		File file = new File(dir, modelClassName + "ServiceImpl.java");
		writeTemplate(file, tpl, modelPackage, modelClassName);
	}

	private static void createResource(File dir, String tpl,
			String modelPackage, String modelClassName, String restPath) {
		File file = new File(dir, modelClassName + "Resource.java");
		tpl = tpl.replaceAll("\\{path\\}", restPath);
		writeTemplate(file, tpl, modelPackage, modelClassName);
	}

	public static void writeTemplate(File file, String tpl,
			String modelPackage, String modelClassName) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			tpl = tpl.replaceAll("\\{name\\}", modelClassName);
			tpl = tpl.replaceAll("\\{pkg\\}", modelPackage);
			writer.write(tpl);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
