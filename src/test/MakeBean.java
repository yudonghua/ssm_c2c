package test;

import net.sf.json.JSONArray;

/**
 * Created by Dell on 2017/5/19.
 */
public class MakeBean {
    public static void main(String args[]){
        String bean = "id gid business customer address status name money num";
        String beans[]=bean.split(",| ");
        getBean(beans);
     //   getXml("customer",beans);

    }
    public static void getXml(String name,String beans[]){
        String upname=(char)(name.charAt(0)+'A'-'a')+name.substring(1);
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        System.out.println("<!DOCTYPE mapper");
        System.out.println("\tPUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"");
        System.out.println("\t\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        System.out.println("<mapper namespace=\""+name+"\">");
        System.out.println("<insert id=\"insert"+upname+"\"  useGeneratedKeys=\"true\" keyProperty=\"id\">");
        String str=beans[0];
        String str2="#{"+beans[0]+"}";
        for(int i=1;i<beans.length;i++){
            str+=","+beans[i];
            str2+=","+"#{"+beans[i]+"}";
        }
        System.out.println("insert into ???."+upname+"("+str+") values("+str2+");");
        System.out.println("</insert>");
        System.out.println("<select id=\"getAll"+upname+"\" resultType=\""+upname+"\">");
        System.out.println("SELECT * FROM "+name);
        System.out.println("</select>");
        System.out.println("<delete id=\"delete"+upname+"\" parameterType=\"long\">");
        System.out.println("delete from ???."+name+" where id = #{id}");
        System.out.println("</delete>");
        System.out.println("</mapper>");
    }
    public  static void getController(String beans[]){
        for(String bean:beans){
            System.out.println("private "+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+"Service "+bean+"Service;");
            System.out.println("public "+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+"Service "+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+"Service(){return "+bean+"Service;}");
            System.out.println("public void set"+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+"Service("+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+"Service "+bean+"Service){this."+bean+"Service="+bean+"Service;}");
        }

    }
    public static void getImpl(String beans[]){
        for(String bean:beans){
            String up = (char)(bean.charAt(0)+'A'-'a')+bean.substring(1);
            System.out.println("private "+up+"Dao "+bean+"Dao;");
            System.out.println("public void insert"+up+"("+up+" "+bean+") {"+bean+"Dao.insert"+up+"("+bean+");}");
            System.out.println("public List<"+up+"> getAll"+up+"() {return this."+bean+"Dao.getAll"+up+"();}");
            System.out.println("public void delete"+up+"(Long id){this."+bean+"Dao.delete"+up+"(id);}");
            System.out.println("public void set"+up+"Dao("+up+"Dao "+up+"Dao) {this."+bean+"Dao = "+up+"Dao;}");
        }}

    public static void getBean(String beans[]) {
        for(String bean:beans){
            System.out.println("private String "+bean+";");
        }
        for(String bean:beans){
            System.out.println("public void set"+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+"(String "+bean+")"+"{this."+bean+"="+bean+";}");
        }
        for(String bean:beans){
            System.out.println("public String get"+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+"()"+"{return this."+bean+";}");
        }
        String str="String "+beans[0];
        for(int i=1;i<beans.length;i++)str+=",String "+beans[i];
        System.out.print("public XXXX("+str+"){");
        str="";
        for(int i=0;i<beans.length;i++)str+="this."+beans[i]+"="+beans[i]+";";
        System.out.println(str+"}");
        System.out.println("public XXXX(){}");
    }
    public static void getDao(String beans[]) {
        for(String bean:beans){
            System.out.println("public void insert"+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)
                    +"("+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+" "+bean+");");
            System.out.println("public void delete"+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)
                    +"();");
            System.out.println("public List<"+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+"> getAll"
                    +(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)+"();");
        }
    }

}
