import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Success extends JFrame
{
Container c;
JLabel head, name, company, pkg;
JTextField txtname, txtcompany, txtpkg;
JButton btnsubmit;

Success(){
c=getContentPane();
c.setLayout(null);
c.setBackground(Color.CYAN);

head=new JLabel("Success Story App");
head.setBounds(57,0,500,40);
head.setFont(new Font("Arial", Font.BOLD, 35));
head.setForeground(Color.BLUE);
c.add(head);

name=new JLabel("Enter Your Name :");
name.setBounds(100,90,300,30);
name.setFont(new Font("Arial", Font.BOLD, 25));
name.setForeground(Color.BLUE);
c.add(name);

txtname=new JTextField(40);
txtname.setBounds(105,130,200,30);
txtname.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtname);

company=new JLabel("Enter Your Company :");
company.setBounds(100,180,300,30);
company.setFont(new Font("Arial", Font.BOLD, 25));
company.setForeground(Color.BLUE);
c.add(company);

txtcompany=new JTextField(40);
txtcompany.setBounds(105,220,200,30);
txtcompany.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtcompany);

pkg=new JLabel("Enter Your Package :");
pkg.setBounds(100,270,300,30);
pkg.setFont(new Font("Arial", Font.BOLD, 25));
pkg.setForeground(Color.BLUE);
c.add(pkg);

txtpkg=new JTextField(40);
txtpkg.setBounds(105,310,200,30);
txtpkg.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtpkg);

btnsubmit=new JButton("Submit");
btnsubmit.setBounds(120,400,170,30);
btnsubmit.setFont(new Font("Arial", Font.BOLD, 25));
btnsubmit.setForeground(Color.BLUE);
c.add(btnsubmit);

ActionListener a = (ae) -> {
String Name=txtname.getText();
String Company=txtcompany.getText();
String Pkg=txtpkg.getText();

try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/Success_Story";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);
String sql="insert into info values(?,?,?) ";
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1, Name);
pst.setString(2, Company);
pst.setString(3, Pkg);
pst.executeUpdate();
JOptionPane.showMessageDialog(c,"Record Inserted Successfully...");

con.close();
}catch(SQLException e){
System.out.println("issue"+e);
}

};
btnsubmit.addActionListener(a);


setSize(450,650);
setLocationRelativeTo(null);
setTitle("success story app by Aman Yadav...");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String args[])
{
Success s=new Success();
}
}