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
	 // items用来跳转 
	 private int item1 = 0; 
	 private int item2 = 1; 
	 private int item3 = 2; 
	 private int item4 = 3; 
	 private JLabel[] FormulaLabels; // 用来存放表达式的各个项 
	 private List<String> allResult; // 用来存放随机出来的结果 
	 private JTextField[] userResults; // 用来让用户输入结果 
	 private JLabel[] judge; // 用来显示图标，以显示用户输入的结果是否正确 
	 private List<String> inputResults = null; // 可以不要 
	 private JTextField scoreField = null; 
	 private int textCount = 1; // 用来记录当前焦点的位置 
	   
	 public static void main(String[] args){ 
	  sa s=new sa(); 
	    
	 } 
	  
	 public sa() { 
	  // TODO Auto-generated constructor stub 
	  inputResults = new ArrayList<String>(); 
	  // 实例化 
	  title = new JLabel("题目很简单，认真答哦！~(每题1分，答对加1分，答错不扣分！)"); 
	  submit = new JButton("提交"); 
	  submit.addActionListener(this); 
	  GridLayout layout = new GridLayout(21, 6); 
	  center = new JPanel(layout); 
	  // 调用方法实例化方法 
	  initLables(); 
	  initUserRestult(); 
	  initJudge(); 
	  // 将各项填入到center面板(GridLayout) 
	  int count = 1; 
	  int formulaCount = 0; 
	  int userResultsCount = 0; 
	  int judgeCount = 0; 
	  while (count <= 120) { 
	   // 判断count%6,确定要填哪个组件 
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
	  center.add(new JLabel("总分：")); 
	  scoreField = new JTextField(); 
	  scoreField.setEditable(false); 
	  center.add(scoreField); 
	  center.add(new JLabel()); 
	  center.add(new JLabel()); 
	  this.add(center, BorderLayout.CENTER); 
	  // 添加组件 
	  this.add(submit, BorderLayout.SOUTH); 
	  this.add(title, BorderLayout.NORTH); 
	  // 显示 
	  this.setLocation(400, 10); 
	  this.setVisible(true); 
	  this.setSize(500, 700); 
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  this.setTitle("简单测试系统"); 
	  try { 
	   Thread.sleep(500); 
	  } catch (InterruptedException e) { 
	   // TODO Auto-generated catch block 
	   e.printStackTrace(); 
	  } 
	  userResults[0].requestFocus(); 
	 } 
	  
	 /** 
	  * 这个方法用来初始化算式各项的数组 
	  */
	 private void initLables() { 
	  int sum; 
	  int firstNumber; 
	  int secondNumber; 
	  allResult = new ArrayList<String>(); 
	  // 建立算式标签 
	  this.FormulaLabels = new JLabel[80]; 
	  // 将数组中的每一个标签都实例化 
	  for (int i = 0; i < 80; i++) { 
	   FormulaLabels[i] = new JLabel(); 
	  } 
	  // 将表达式各项赋值内容，并将随机数的和算出结果存入Arraylist中,以便后期核对结果使用 
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
	  * 这个方法用来实例化userResults数组，并实例化里面的每一个JTextField 
	  */
	 private void initUserRestult() { 
	  userResults = new JTextField[20]; 
	  for (int i = 0; i < 20; i++) { 
	   userResults[i] = new JTextField(); 
	   userResults[i].setSize(20, 20); 
	   // 后加的监听 
	   userResults[i].addKeyListener(this); 
	  } 
	 } 
	  
	 /** 
	  * 这个方法用来实例化judge数组，并将里面的每一个Label实例化 
	  */
	 private void initJudge() { 
	  judge = new JLabel[20]; 
	  for (int i = 0; i < 20; i++) { 
	   judge[i] = new JLabel("好好算呦"); 
	  } 
	 } 
	  
	 // 实现监听方法，当用户点击提交后要做的事情 
	 @Override
	 public void actionPerformed(ActionEvent arg0) { 
	  // TODO Auto-generated method stub 
	  int score = 0; 
	  for (int i = 0; i < 20; i++) { 
	   // 将用户输入的结果全部获取，存入一个ArrayList中,可以不要 
	   inputResults.add(userResults[i].getText().toString().trim()); 
	   System.out.println(userResults[i].getText().toString()); 
	   // 取出来用户输入的答案和之前算好的结果去比较，不对就把后面的标签设置为回答错误， 
	   // 如果正确就设置为回答正确 
	   String result = userResults[i].getText().toString().trim(); 
	   if (result.equals(allResult.get(i))) { 
	    judge[i].setText("回答正确"); 
	    judge[i].setForeground(Color.RED); 
	    score++; 
	   } else { 
	    judge[i].setText("回答错误"); 
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
	
