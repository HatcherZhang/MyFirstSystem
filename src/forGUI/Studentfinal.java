package forGUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Studentfinal extends JFrame implements ActionListener{
	 JButton B;
    public Studentfinal(String s){
    	JLabel L;
       
    	setTitle("����С��ʿ");
    	setLayout(null);
    	setSize(400,200);
    	setVisible(true);
    	setLocation(350,200);
    	L=new JLabel(s);
    	//setBackground(Color.red); 
    	B=new JButton("ȷ��");
    	B.addActionListener(this);
    	L.setBounds(100,10,280,100);
    	B.setBounds(160,80, 65, 35);
    	L.setFont(new Font("",Font.BOLD,15));
    	L.setAlignmentX(Label.CENTER);
    	
    	add(L);
    	add(B);
    }
    public void actionPerformed(ActionEvent e){
		if(e.getSource()==B) this.dispose();//��CheckIDAndPasswordʹ��
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new Studentfinal("ɾ���ɹ�,�����²鿴");
	}

}
