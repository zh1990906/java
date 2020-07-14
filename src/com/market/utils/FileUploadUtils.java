/**
 * 
 */
package com.market.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * 
 * @author ZH
 * 上午10:46:05
 */
public class FileUploadUtils {
	public static Map<String,String> upload(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Map<String,String> map = new HashMap<>();	
		DiskFileItemFactory dfif = new DiskFileItemFactory();//创建本地磁盘对象
			//以上对象中包含有解析器的默认配置
			ServletFileUpload sfu =new ServletFileUpload(dfif);//解析器-->解析request对象的输入流
			try {
				List<FileItem> items = sfu.parseRequest(req);//解析request请求输入流
				//遍历表单中的所有数据-->区分上传文件域和普通表单域
				for(FileItem item:items){
					if(item.isFormField()){
						//普通表单域
						String attrName = item.getFieldName();//获取表单中name属性值
						String val = item.getString("utf-8");//普通表单中的value值
						map.put(attrName, val);
					}else{
						//上传文件域
						String attrName = item.getFieldName();//获取表单中name属性值
						String fileName = item.getName();//获取图片(非IE浏览器)或者图片路径(IE浏览器)
						System.out.println("----"+fileName+"------------");
						//解决浏览器兼容性问题   File.separator-->文件路径中斜杠
						fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
							//设定文件上传的路径
							String path = "E:/img";
							File f = new File(path);
							if(!f.exists()){
								f.mkdir();
							}
							if(fileName==null||fileName==""){
								map.put(attrName, null);
							}else{
								//防止文件名重复
								fileName = UUID.randomUUID().toString()+fileName;
								//实现上传
								File file = new File(path+File.separator+fileName);
								//将文件名保存到map中
								map.put(attrName, fileName);
								item.write(file);
							}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return map;
	}
}
