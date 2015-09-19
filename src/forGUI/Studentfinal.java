package forGUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Studentfinal extends JFrame implements ActionListener{
	 JButton B;
    public Studentfinal(String s){
    	JLabel L;
       
    	setTitle("爱心小贴士");
    	setLayout(null);
    	setSize(400,200);
    	setVisible(true);
    	setLocation(350,200);
    	L=new JLabel(s);
    	//setBackground(Color.red); 
    	B=new JButton("确定");
    	B.addActionListener(this);
    	L.setBounds(100,10,280,100);
    	B.setBounds(160,80, 65, 35);
    	L.setFont(new Font("",Font.BOLD,15));
    	L.setAlignmentX(Label.CENTER);
    	
    	add(L);
    	add(B);
    }
    public void actionPerformed(ActionEvent e){
		if(e.getSource()==B) this.dispose();//给CheckIDAndPassword使用
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new Studentfinal("删除成功,请重新查看");
	}

}
