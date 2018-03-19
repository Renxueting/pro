package autoScore;

	import java.awt.BorderLayout; 
	import java.awt.Color; 
	import java.awt.GridLayout; 
	import java.awt.event.ActionEvent; 
	import java.awt.event.ActionListener; 
	import java.awt.event.KeyEvent; 
	import java.awt.event.KeyListener; 
	import java.util.ArrayList; 
	import java.util.List; 
	import java.util.Random; 
	  
	import javax.swing.JButton; 
	import javax.swing.JFrame; 
	import javax.swing.JLabel; 
	import javax.swing.JPanel; 
	import javax.swing.JTextField; 
	  
	/** 
	 * 2017-01-09 
	 * @author Koow 
	 * 
	 */
	public class sa extends JFrame implements ActionListener, KeyListener { 
	 private JLabel title = null; 
	 private JButton submit = null; 
	 private JPanel center = null; 
	 // items������ת 
	 private int item1 = 0; 
	 private int item2 = 1; 
	 private int item3 = 2; 
	 private int item4 = 3; 
	 private JLabel[] FormulaLabels; // ������ű��ʽ�ĸ����� 
	 private List<String> allResult; // ���������������Ľ�� 
	 private JTextField[] userResults; // �������û������� 
	 private JLabel[] judge; // ������ʾͼ�꣬����ʾ�û�����Ľ���Ƿ���ȷ 
	 private List<String> inputResults = null; // ���Բ�Ҫ 
	 private JTextField scoreField = null; 
	 private int textCount = 1; // ������¼��ǰ�����λ�� 
	   
	 public static void main(String[] args){ 
	  sa s=new sa(); 
	    
	 } 
	  
	 public sa() { 
	  // TODO Auto-generated constructor stub 
	  inputResults = new ArrayList<String>(); 
	  // ʵ���� 
	  title = new JLabel("��Ŀ�ܼ򵥣������Ŷ��~(ÿ��1�֣���Լ�1�֣�����۷֣�)"); 
	  submit = new JButton("�ύ"); 
	  submit.addActionListener(this); 
	  GridLayout layout = new GridLayout(21, 6); 
	  center = new JPanel(layout); 
	  // ���÷���ʵ�������� 
	  initLables(); 
	  initUserRestult(); 
	  initJudge(); 
	  // ���������뵽center���(GridLayout) 
	  int count = 1; 
	  int formulaCount = 0; 
	  int userResultsCount = 0; 
	  int judgeCount = 0; 
	  while (count <= 120) { 
	   // �ж�count%6,ȷ��Ҫ���ĸ���� 
	   if (count % 6 == 1 || count % 6 == 2 || count % 6 == 3 || count % 6 == 4) { 
	    center.add(FormulaLabels[formulaCount]); 
	    formulaCount++; 
	   } else if (count % 6 == 5) { 
	    center.add(userResults[userResultsCount]); 
	    userResultsCount++; 
	   } else if (count % 6 == 0) { 
	    center.add(judge[judgeCount]); 
	    judgeCount++; 
	   } 
	   count++; 
	  } 
	  center.add(new JLabel()); 
	  center.add(new JLabel()); 
	  center.add(new JLabel("�ܷ֣�")); 
	  scoreField = new JTextField(); 
	  scoreField.setEditable(false); 
	  center.add(scoreField); 
	  center.add(new JLabel()); 
	  center.add(new JLabel()); 
	  this.add(center, BorderLayout.CENTER); 
	  // ������ 
	  this.add(submit, BorderLayout.SOUTH); 
	  this.add(title, BorderLayout.NORTH); 
	  // ��ʾ 
	  this.setLocation(400, 10); 
	  this.setVisible(true); 
	  this.setSize(500, 700); 
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  this.setTitle("�򵥲���ϵͳ"); 
	  try { 
	   Thread.sleep(500); 
	  } catch (InterruptedException e) { 
	   // TODO Auto-generated catch block 
	   e.printStackTrace(); 
	  } 
	  userResults[0].requestFocus(); 
	 } 
	  
	 /** 
	  * �������������ʼ����ʽ��������� 
	  */
	 private void initLables() { 
	  int sum; 
	  int firstNumber; 
	  int secondNumber; 
	  allResult = new ArrayList<String>(); 
	  // ������ʽ��ǩ 
	  this.FormulaLabels = new JLabel[80]; 
	  // �������е�ÿһ����ǩ��ʵ���� 
	  for (int i = 0; i < 80; i++) { 
	   FormulaLabels[i] = new JLabel(); 
	  } 
	  // �����ʽ���ֵ���ݣ�����������ĺ�����������Arraylist��,�Ա���ں˶Խ��ʹ�� 
	  while (item4 < 80) { 
	   firstNumber = new Random().nextInt(99) + 1; 
	   FormulaLabels[item1].setText(String.valueOf(firstNumber)); 
	   FormulaLabels[item2].setText("+"); 
	   secondNumber = new Random().nextInt(99) + 1; 
	   FormulaLabels[item3].setText(String.valueOf(secondNumber)); 
	   FormulaLabels[item4].setText("="); 
	   sum = firstNumber + secondNumber; 
	   allResult.add(String.valueOf(sum)); 
	   item1 += 4; 
	   item2 += 4; 
	   item3 += 4; 
	   item4 += 4; 
	  } 
	  // for(int i=0;i<80;i++){ 
	  // System.out.println(FormulaLabels[i].getText()); 
	  // } 
	 } 
	  
	 /** 
	  * �����������ʵ����userResults���飬��ʵ���������ÿһ��JTextField 
	  */
	 private void initUserRestult() { 
	  userResults = new JTextField[20]; 
	  for (int i = 0; i < 20; i++) { 
	   userResults[i] = new JTextField(); 
	   userResults[i].setSize(20, 20); 
	   // ��ӵļ��� 
	   userResults[i].addKeyListener(this); 
	  } 
	 } 
	  
	 /** 
	  * �����������ʵ����judge���飬���������ÿһ��Labelʵ���� 
	  */
	 private void initJudge() { 
	  judge = new JLabel[20]; 
	  for (int i = 0; i < 20; i++) { 
	   judge[i] = new JLabel("�ú�����"); 
	  } 
	 } 
	  
	 // ʵ�ּ������������û�����ύ��Ҫ�������� 
	 @Override
	 public void actionPerformed(ActionEvent arg0) { 
	  // TODO Auto-generated method stub 
	  int score = 0; 
	  for (int i = 0; i < 20; i++) { 
	   // ���û�����Ľ��ȫ����ȡ������һ��ArrayList��,���Բ�Ҫ 
	   inputResults.add(userResults[i].getText().toString().trim()); 
	   System.out.println(userResults[i].getText().toString()); 
	   // ȡ�����û�����Ĵ𰸺�֮ǰ��õĽ��ȥ�Ƚϣ����ԾͰѺ���ı�ǩ����Ϊ�ش���� 
	   // �����ȷ������Ϊ�ش���ȷ 
	   String result = userResults[i].getText().toString().trim(); 
	   if (result.equals(allResult.get(i))) { 
	    judge[i].setText("�ش���ȷ"); 
	    judge[i].setForeground(Color.RED); 
	    score++; 
	   } else { 
	    judge[i].setText("�ش����"); 
	    judge[i].setForeground(Color.GREEN); 
	   } 
	  } 
	  scoreField.setText(String.valueOf(score)); 
	 } 
	  
	 @Override
	 public void keyPressed(KeyEvent e) { 
	  // TODO Auto-generated method stub 
	  if (e.getKeyCode() == KeyEvent.VK_ENTER) { 
	   userResults[textCount].requestFocus(); 
	   if (textCount < 19) { 
	    textCount++; 
	   } 
	  } 
	 } 
	  
	 @Override
	 public void keyTyped(KeyEvent e) { 
	  // TODO Auto-generated method stub 
	  
	 } 
	  
	 @Override
	 public void keyReleased(KeyEvent e) { 
	  // TODO Auto-generated method stub 
	  
	 } 
	}
	
