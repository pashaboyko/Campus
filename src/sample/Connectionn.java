package sample;


import sample.pojo.*;


import java.sql.*;



public class Connectionn {
    private static final String url = "jdbc:mysql://localhost:3306/Lol";
    private static final String user = "root";
    private static final String password = "12345678";
    private static java.sql.Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public static String stringKA72[]={"Мат. аналіз","Мат. логіка","ООП","Теорія Ймовірностей","Фізика","АОС","Диф. рівняння","Іноземна мова"};
public Connectionn(){
    try {
        // opening database connection to MySQL server
        con = DriverManager.getConnection(url, user, password);

        // getting Statement object to execute query
        stmt = con.createStatement();
    } catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
    }


}
   public   void OutInfo (){

       try {


           String queryy = "select idStudak, name, surname, numPhone, dates,groupp,hasAcc from Studak";

           rs = stmt.executeQuery(queryy);

           while (rs.next()) {
               int id = rs.getInt(1);
               String name = rs.getString(2);
               String surname = rs.getString(3);
               Date date= rs.getDate(5);
               System.out.printf("id" + id +  "name: " + name + "surname: " +  surname + " date: " + date + "%n");
           }
           String queryy1 = "select idStudent, name, surname, numPhone, password, login, dates , groupp  from Student";

           rs = stmt.executeQuery(queryy1);


           while (rs.next()) {
               int id = rs.getInt(1);
               String name = rs.getString(2);
               String surname = rs.getString(3);
               Date date= rs.getDate(7);
               System.out.printf("id: " + id +  " name: " + name + " surname: " +  surname + " Date: " + date + "%n");
           }



       } catch (SQLException sqlEx) {
           sqlEx.printStackTrace();
       }

   }

   public  void close(){

           try { con.close(); } catch(SQLException se) { /*can't do anything */ }
           try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
           try { rs.close(); } catch(SQLException se) { /*can't do anything */ }

   }

   boolean studackCheck(int id, String psw, String login, String password){
       String queryy = "select  idStudak, name,surname, password, numPhone,dates,groupp, hasAcc  from Studak";
       try {
       rs = stmt.executeQuery(queryy);
       String group=new String();
       String name=new String();
       String surname=new String();


           while (rs.next()) {


               String b = new String(rs.getString(4));
               if(b.equals(psw)){
                   if(id==rs.getInt(1)){
                       if(!rs.getBoolean(8)){
                           String addTableSQL = "INSERT INTO Student(idStudent, name, surname, numPhone,password,login,dates, groupp) VALUES ("+rs.getInt(1)+","
                                   +"'"+rs.getString(2)+"',"
                                   +"'"+rs.getString(3)+"',"
                                   +"'"+rs.getString(5)+"',"
                                   +"'"+password+"',"
                                   +"'"+login+"',"
                                   +"'"+rs.getDate(6)+"',"
                                   +"'"+rs.getString(7)+"')";
                           group=rs.getString(7);
                           surname=rs.getString(3);
                           name=rs.getString(2);
                           int idd=rs.getInt(1);

                           if(group.equals("КА-72")||group.equals("КА-71")||group.equals("КА-73")||group.equals("КА-74")||group.equals("КА-75")||group.equals("КА-76")||group.equals("КА-77")){
                               for(int i=0; i<7;i++){
                                   String addTable = "INSERT INTO Marks(idMarks, Name, Surname, predmet, marks) VALUES ("+id+","
                                           +"'"+name+"',"
                                           +"'"+surname+"',"
                                           +"'"+stringKA72[i]+"',"
                                           +0+")";
                                   try {
                                       stmt.executeUpdate(addTable);
                                   } catch (SQLException e) {
                                       System.out.println(e.getMessage());
                                   }}}
                           try {

                               stmt.executeUpdate(addTableSQL);
                           } catch (SQLException e) {
                               System.out.println(e.getMessage());
                           }
                           String updateTableSQL = "UPDATE Studak SET hasAcc = true where idStudak="+id;
                           try {

                               stmt.execute(updateTableSQL);

                           } catch (SQLException e) {
                               System.out.println(e.getMessage());
                           }
                           return true;
                       }
                   }
               }
           }
           return false;
       } catch (SQLException sqlEx) {
           sqlEx.printStackTrace();
           return false;
       }

   }

    public void addtoProgrammMarks(){
    objList.markss.clear();


        try {

            String queryy3 = "select idMarks, Name, Surname, predmet, marks from Marks";

            rs = stmt.executeQuery(queryy3);
            while (rs.next()) {
                objList.markss.add(new Marrks(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5)));
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }

    public void addtoProgrammSched(){
        objList.schedules.clear();

        try {

            String queryy3 = "select idSchedule, subject, room, changee,weekk, groupp, dayy from Schedule";

            rs = stmt.executeQuery(queryy3);
            while (rs.next()) {
                objList.schedules.add(new Schedule(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5), rs.getString(6), rs.getString(7)));
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }
    public void addtoProgrammTeacherCombinatoin(){
        objList.teacherCombinations.clear();

        try {

            String queryy3 = "select id, subject, groupp from TeacherCombination";

            rs = stmt.executeQuery(queryy3);
            while (rs.next()) {
                objList.teacherCombinations.add(new TeacherCombination(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }





    public void addtoProgramm(){
    objList.accounts.clear();
    objList.teachers.clear();

       try {
           String queryy1 = "select idStudent, name, surname, numPhone, password, login, dates , photos,  groupp  from Student";

           rs = stmt.executeQuery(queryy1);


           while (rs.next()) {
               objList.accounts.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getDate(7), rs.getString(8), rs.getString(9)));
           }

           String queryy2 = "select id, name, surname, numPhone, password, login, dates , photos,  yourGroup  from Teacher";

           rs = stmt.executeQuery(queryy2);


           while (rs.next()) {
               objList.teachers.add(new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getDate(7), rs.getString(8), rs.getString(9)));
           }




       } catch (SQLException sqlEx) {
           sqlEx.printStackTrace();
       }

   }


    public void edElement(int id, String subject, int bals) {

        String updateTableSQL = "UPDATE Marks SET marks ="+bals+" where idMarks="+id+" and predmet="+"'"+subject+"' ";
        System.out.println(updateTableSQL);
        try {

            stmt.execute(updateTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}













