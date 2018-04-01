
package bookshop;

import java.io.File;


public class DbMDReadAndWriter {
   private static final String FOLDER="C:\\ProgramData\\OpenSolution\\BookShop";
   private static final String FILE=".xml";
   
   public static void createIfNotExists() {
       File floders=new File(FOLDER);
       boolean exst=floders.exists();
       if (!exst) {
         floders.mkdirs();
         File xmlFile=new File(FOLDER+"\\"+FILE);
           if (!xmlFile.exists()) {
               try {
                   xmlFile.createNewFile();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }
   }
   
   
   
   
   

   
}
