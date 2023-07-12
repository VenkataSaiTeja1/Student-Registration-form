import java.awt.BorderLayout;
 
import java.awt.Checkbox;
 
import java.awt.CheckboxGroup;
 
import java.awt.Color;
 
import java.awt.Font;
 
import java.awt.TextArea;
 
import java.awt.event.ActionEvent;
 
import java.awt.event.ActionListener;
 
import java.awt.event.ItemEvent;
 
import java.awt.event.ItemListener;
 
import java.awt.event.KeyAdapter;
 
import java.awt.event.KeyEvent;
 
import java.sql.Connection;
 
import java.sql.DriverManager;
 
import java.sql.PreparedStatement;
 
import java.sql.SQLException;
 
import java.sql.Statement;
 
 
import javax.swing.ImageIcon;
 
import javax.swing.JButton;
 
import javax.swing.JComboBox;
 
import javax.swing.JFrame;
 
import javax.swing.JLabel;
 
import javax.swing.JOptionPane;
 
import javax.swing.JTextField;
 
public class Studentregistration
 
{  
 
    JTextField t1,t2,t3,t4;
 
    JButton submit,reset;
 
    JLabel head,fname,lname,faname,date,g,warn,adress;
 
    JFrame f;
 
    JComboBox d,m,y,corse;
 
    CheckboxGroup gen;
 
    TextFieldExample() 
 
    {
 
    f= new JFrame("Student Registration Form");
 
    //Creating a Label for Headline
 
    
 
   head = new JLabel("Student Registration Form");
 
   head.setBounds(150,10,500,50);
 
   head.setFont(new Font("Times new roman",Font.BOLD,40));
 
  
 
    
 
    //Creating label and TextField for take first name of student
 
    
 
    fname=new JLabel("First Name :");
 
    fname.setBounds(190,90, 85, 25);
 
    fname.setFont(new Font("Times new roman",Font.BOLD,16));
 
    t1=new JTextField(""); 
 
    t1.setBorder(null);
 
    t1.setBackground(null);
 
    t1.setBounds(280,90, 250,30);
 
    
 
    //Creating label and TextField for take last name of student
 
    
 
    lname=new JLabel("Last Name :");
 
    lname.setBounds(190,140, 85, 25);
 
    lname.setFont(new Font("Times new roman",Font.BOLD,16));
 
    t2=new JTextField();
 
    t2.setBorder(null);
 
    t2.setBackground(null);
 
    t2.setBounds(280,140, 250,30);
 
    
 
    faname=new JLabel("Father's Name :");
 
    faname.setBounds(175, 190, 100, 25);
 
    faname.setFont(new Font("times new roman",Font.BOLD,16));
 
    t3=new JTextField();
 
    t3.setBorder(null);
 
    t3.setBackground(null);
 
    t3.setBounds(280,190,250,30);
 
    
 
    date=new JLabel("Date of birth(yy,mm,dd) :");
 
    date.setBounds(100, 240, 200, 25);
 
    date.setFont(new Font("times new roman",Font.BOLD,16));
 
    d=new JComboBox<>();
 
    d.addItem(null);
 
    {
 
        for(int i=01;i<32;i++)
 
            d.addItem(i);
 
    }
 
   d.setBounds(480,240,50,30);
 
    
 
   m=new JComboBox<>();
 
   m.addItem(null);
 
    for(int i=1;i<=12;i++)
 
    {
 
         m.addItem(i);
 
    }
 
   m.setBounds(390,240,50,30);
 
    m.addItemListener(new ItemListener() 
 
    {
 
        public void itemStateChanged(ItemEvent e) 
 
        {
 
            int month=(int)m.getSelectedItem();
 
            if(month==2)
 
            {
 
                d.removeItem("31");
 
                d.removeItem("30");
 
                d.removeItem("29");
 
                if(Integer.parseInt((String)y.getSelectedItem())%4==0)
 
                {
 
                d.addItem("29");
 
                }
 
            }
 
            else if(month==4 || month==6 || month==9 || month==11)
 
            {
 
                d.removeItem("31");
 
            }
 
        }
 
    });
 
   
 
    y=new JComboBox<>();
 
    y.addItem(null);
 
    {
 
        for(int i=1995;i<2023;i++)
 
            y.addItem(i);
 
    }
 
    y.setBounds(280,240,60,30);
 
    
 
    g=new JLabel("Gender :");
 
    g.setBounds(210,300,75,30);
 
    g.setFont(new Font("times new roman",Font.BOLD,16));
 
    gen=new CheckboxGroup();
 
    Checkbox male=new Checkbox("Male",gen,false);
 
    male.setBounds(305,300,75,25);
 
    male.setBackground(null);
 
    male.setFont(new Font("times new roman",Font.BOLD,14));
 
    Checkbox female=new Checkbox("Female",gen,false);
 
    female.setBounds(400,300,75,25);
 
    female.setBackground(null);
 
    female.setFont(new Font("times new roman",Font.BOLD,14));
 
    
 
    JLabel mob=new JLabel("Mobile Number :");
 
    mob.setBounds(155,360,120,30);
 
    mob.setFont(new Font("times new Roman",Font.BOLD,16));
 
    t4 =new JTextField();
 
    t4.setBorder(null);
 
    t4.setBackground(null);
 
    t4.setBounds(280,360,250,30);
 
    t4.addKeyListener(new KeyAdapter() 
 
    {
 
        public void keyPressed(KeyEvent ke)
 
        {
 
            f.add(warn=new JLabel());
 
            if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
 
            {
 
                t4.setEditable(true);
 
                
 
            }
 
            else
 
            {
 
                warn.setText("Enter only numeric digits(0-9)");
 
                warn.setFont(new Font("Times new Roman",Font.LAYOUT_RIGHT_TO_LEFT,12));
 
                warn.setForeground(Color.red);
 
                warn.setBounds(280,390,250,35);
 
            }
 
            
 
        }
 
    });
 
    
 
    adress=new JLabel("Address :");
 
    adress.setBounds(210,420,60,30);
 
    adress.setFont(new Font("times new roman",Font.BOLD,16));
 
    TextArea area=new TextArea();
 
    area.setBackground(null);
 
    area.setBounds(280,420,250,150);
 
    area.setBackground(null);
 
    JLabel cors=new JLabel("Enter Course Name :");
 
    cors.setBounds(130,600,170,30);
 
    cors.setFont(new Font("Times new Roman",Font.BOLD,16));
 
    corse=new JComboBox<>();
 
    corse.addItem(null);
 
    corse.addItem("C Language");
 
    corse.addItem("Java Full Stack");
 
    corse.addItem("Python Full Stack");
 
    corse.setBounds(280,600,130,30);
 
    
 
    submit =new JButton("Submit");
 
       submit.setBounds(400,700,100,30);
 
    submit.addActionListener(new ActionListener()
 
            {
 
        public void actionPerformed(ActionEvent ae)
 
        {
 
            
 
            if(t1.getText().equals(""))
 
            {
 
                JOptionPane.showMessageDialog(f, "Enter First Name");
 
            }
 
            else if(t2.getText().equals(""))
 
            {
 
                JOptionPane.showMessageDialog(f, "Enter Last Name");
 
            }
 
            else if(t3.getText().equals(""))
 
            {
 
                JOptionPane.showMessageDialog(f, "Enter Father's Name");
 
            }
 
            else    if(d.getSelectedItem()==null || m.getSelectedItem()==null || y.getSelectedItem()==null)
 
            {
 
                JOptionPane.showMessageDialog(f, "Enter Date of Birth or Check its properly given or not");
 
            }
 
            else if(gen.getSelectedCheckbox()==null)
 
            {
 
                JOptionPane.showMessageDialog(f, "Select Gender");
 
            }
 
            else if(t4.getText().equals(""))
 
            {
 
                JOptionPane.showMessageDialog(f, "Enter Mobile Number");
 
            }
 
            else if(area.getText().isEmpty())
 
            {
 
                JOptionPane.showMessageDialog(f, "Enter Address");
 
            }
 
            else if(corse.getSelectedItem()==null)
 
            {
 
                JOptionPane.showMessageDialog(f, "Select your Course");
 
            }
 
            else
 
            {
 
                try {
 
                Class.forName("oracle.jdbc.driver.OracleDriver");
 
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
 
                Statement st=con.createStatement();
 
                try {
 
                st.executeQuery("select *from StudreTable");
 
                }catch(SQLException se) {
 
                    st.executeUpdate("create table StudreTable(StudName varchar2(35),studFaname varchar2(35),studDOB Date,studGen varchar2(6),studMobNum number(10),studAddres varchar2(100),studCorse varchar2(20))");
 
                }
 
                String qry="insert into StudreTable values(?,?,?,?,?,?,?)";
 
                PreparedStatement ps=con.prepareStatement(qry);
 
                ps.setString(1, t1.getText()+" "+t2.getText());
 
                ps.setString(2, t3.getText());
 
                String dat=String.valueOf(y.getSelectedItem())+"-"+String.valueOf(m.getSelectedItem())+"-"+String.valueOf(d.getSelectedItem());
 
                ps.setDate(3, java.sql.Date.valueOf(dat));
 
                ps.setString(4,gen.getSelectedCheckbox().getLabel());
 
                long mob=Long.valueOf(t4.getText());
 
                ps.setLong(5, mob);
 
                ps.setString(6, area.getText());
 
                ps.setString(7, corse.getSelectedItem().toString());
 
                int rs1=ps.executeUpdate();
 
                if(rs1==1)
 
                {
 
                    JOptionPane.showMessageDialog(f, "Registration Successfully Completed!");
 
                }
 
                else
 
                {
 
                    JOptionPane.showMessageDialog(f, "There is a problem to Store your Data!");    
 
                }
 
                }catch(Exception e) {JOptionPane.showMessageDialog(f, e.getMessage());}
 
            }
 
            }
 
            });
 
    reset=new JButton("Reset");
 
    reset.setBounds(250,700,100,30);
 
    reset.addActionListener(new ActionListener()
 
            {
 
        public void actionPerformed(ActionEvent ae)
 
            {
 
            t1.setText(null);
 
            t2.setText(null);
 
            t3.setText(null);
 
            t4.setText(null);
 
            gen.setSelectedCheckbox(null);
 
            d.setSelectedIndex(0);
 
            m.setSelectedIndex(0);
 
            corse.setSelectedIndex(0);
 
            area.selectAll();
 
            area.setText("");
 
            }
 
        });
 
    f.setSize(800,800);  
 
    f.setLayout(new BorderLayout());
 
    f.setContentPane(new JLabel(new ImageIcon("D:\\Eclips\\1\\src\\Back Ground.png")));
 
    
 
    f.setVisible(true); 
 
    f.add(head);f.add(t1); f.add(t2); f.add(fname); f.add(lname);f.add(faname);f.add(t3);f.add(date);f.add(d);f.add(m);f.add(y);f.add(g);f.add(male);f.add(female);f.add(mob);f.add(t4);f.add(adress);f.add(area);f.add(submit);
 
    f.add(cors);f.add(corse);f.add(reset);
 
    }
 
    public static void main(String args[])
 
    {
 
        new Studentregistration();
 
    }
 
}
