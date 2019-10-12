package com.fjh.backup.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * MySQL备份还原工具类
 */
public class MySqlBackupRestoreUtils {
	static Logger logger = LoggerFactory.getLogger(MySqlBackupRestoreUtils.class);
	/**
	 * 备份数据库
	 * @param host host地址，可以是本机也可以是远程
	 * @param userName 数据库的用户名
	 * @param password 数据库的密码
	 * @param backupFolderPath 备份的路径
	 * @param fileName 备份的文件名
	 * @param database 需要备份的数据库的名称
	 * @return
	 * @throws IOException 
	 */
	public static boolean backup(String host, String userName, String password, String backupFolderPath, String fileName,
			String database) throws Exception {
		File backupFolderFile = new File(backupFolderPath);
		if (!backupFolderFile.exists()) {
			// 如果目录不存在则创建
			backupFolderFile.mkdirs();
		}
		if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
			backupFolderPath = backupFolderPath + File.separator;
		}
		// 拼接命令行的命令
		String backupFilePath = backupFolderPath + fileName;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("mysqldump --opt ").append(" --add-drop-database ").append(" --add-drop-table ");
		stringBuilder.append(" -h").append(host).append(" -u").append(userName).append(" -p").append(password);
		stringBuilder.append(" --result-file=").append(backupFilePath).append(" --default-character-set=utf8 ").append(database);
		// 调用外部执行 exe 文件的 Java API
		System.out.println(stringBuilder.toString());
		for (String c : getCommand(stringBuilder.toString())) {
			System.out.println(c);
		}
		Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
		//调试打印出错误信息，windows注意编码的格式是GBK
		printMessage(process.getInputStream());
		printMessage(process.getErrorStream());
		System.out.println(process.waitFor());
		if (process.waitFor() == 0) {
			// 0 表示线程正常终止
			System.out.println("数据已经备份到 " + backupFilePath + " 文件中");
			return true;
		}
		System.out.println("备份失败!");
		return false;
	}

    /**
     * 还原数据库
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host IP地址
     * @param database 数据库名称
     * @param userName 用户名
     * @param password 密码
     * @return
     */
	public static boolean restore(String restoreFilePath, String host, String userName, String password, String database)
			throws Exception {
		File restoreFile = new File(restoreFilePath);
		if (restoreFile.isDirectory()) {
			for (File file : restoreFile.listFiles()) {
				if (file.exists() && file.getPath().endsWith(".sql")) {
					restoreFilePath = file.getAbsolutePath();
					break;
				}
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("mysql -h").append(host).append(" -u").append(userName).append(" -p").append(password);
		stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);

		for (String c : getCommand(stringBuilder.toString())) {
			System.out.println(c);
		}
		try {
			Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
			if (process.waitFor() == 0) {
				System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
			}else{
				System.out.println("导入失败！");
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 判断执行命令是linux 还是 windows
	 * @param command
	 * @return
	 */
	private static String[] getCommand(String command) {
		String os = System.getProperty("os.name");  
		String shell = "/bin/bash";
		String c = "-c";
		if(os.toLowerCase().startsWith("win")){  
			shell = "cmd";
			c = "/c";// /c表示执行完命令后关闭cmd窗口
		}  
		String[] cmd = { shell, c, command };
		return cmd;
	}

	//测试
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		String userName = "root";
		String password = "123456";
		String database = "test_backup";
		
	/*	System.out.println("开始备份...");
		String backupFolderPath = "c:/dev/";
		String fileName = "ycu.sql";
		backup(host, userName, password, backupFolderPath, fileName, database);*/
		//mysqldump --opt  --add-drop-database  --add-drop-table  -hlocalhost -uroot -p123456 --result-file=c:/dev/ycu.sql --default-character-set=utf8 test_backup
		System.out.println("开始还原...");
		String restoreFilePath = "c:/dev/ycu.sql";
		restore(restoreFilePath, host, userName, password, database);


	}

	/**
	 * 调试打印输出执行命令的日志
	 * @param input
	 */
	private static void printMessage(final InputStream input) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Reader reader = new InputStreamReader(input,"GBK");
				BufferedReader bf = new BufferedReader(reader);
				String line = null;

					while((line=bf.readLine())!=null) {
						logger.info(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
		}).start();
	}

}
