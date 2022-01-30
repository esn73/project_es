package DoughnutsKiosk;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.Icon;
import javax.swing.SwingConstants;

public class DounutskioskMain extends JFrame {

	private List<Donuts> donuts;

	private static final String[] IMAGES = { "images/back.png", "images/logo.png", };

	private static final String[] MENUIMG = { "images/dn_org.png", "images/dn_menu2.png", "images/dn_menu3.png",
			"images/dn_menu4.png", "images/cf_menu1.png", "images/cf_menu2.png", "images/cf_menu3.png",
			"images/cf_menu4.png" };

	private static final String[] DNMENU = { "오리지널 글레이즈드", "카라멜 글레이즈드", "초콜릿 아이스글레이즈드", "루돌프", "아이스 아메리카노", "아메리카노",
			"바닐라 라떼", "살구자두 스무디" };
	private static final int PRICE[] = { 1500, 1700, 1700, 2500, 4200, 3700, 4400, 5500 };
	private static final String[] ORDER_COLUMN = { "No", "상품명", "수량", "금액", "총 합계" };

	private JFrame frame;
	private JLabel LabelLogoimg;
	private int index;
	private JLabel Labelback;
	private JLabel LabelDnImg1;
	private JLabel dn1_menu;
	private JLabel dn1_price;
	private JLabel LabelDnImg2;
	private JLabel LabelDnImg3;
	private JTable table;
	private DefaultTableModel model;

	private JSpinner dn1_count;
	private JSpinner dn2_count;
	private JSpinner dn3_count;

	// Controller 역할하는 변수
	private DonutsDao dao;
	private JLabel dn3_price;
	private JLabel dn2_price;
	private JTextField textTotal;
	private JButton btnCancle;
	private JButton btnSelectCancle;
	private JScrollPane scrollPane;
	private JLabel cf1_menu;
	private JLabel dn5_price;
	private JSpinner cf1_count;
	private JLabel cf2_menu;
	private JLabel dn6_price;
	private JSpinner cf2_count;
	private JLabel cf3_menu;
	private JLabel dn7_price;
	private JSpinner cf3_count;
	private JLabel LabelDnImg6;
	private JLabel LabelDnImg7;
	private JLabel LabelDnImg5;
	private JLabel LabelDnImg4;
	private JLabel dn3_menu_1;
	private JLabel dn3_price_1;
	private JSpinner cf4_count;
	private JLabel dn8_price;
	private JLabel cf4_menu;
	private JSpinner dn4_count;
	private JLabel LabelDnImg8;

	public interface Oracledb {

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DounutskioskMain window = new DounutskioskMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public DounutskioskMain() {
		dao = DonutsdaoImpl.getInstance(); // singleton
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		frame.setTitle("크리스피크림도넛 키오스크");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		LabelLogoimg = new JLabel(new ImageIcon(IMAGES[1]));
		LabelLogoimg.setBounds(315, 10, 130, 70);
		frame.getContentPane().add(LabelLogoimg);

		Labelback = new JLabel(new ImageIcon(IMAGES[0]));
		Labelback.setBounds(0, 0, 815, 64);
		frame.getContentPane().add(Labelback);

		JTabbedPane PaneMenu = new JTabbedPane(JTabbedPane.TOP);
		PaneMenu.setForeground(new Color(0, 128, 0));
		PaneMenu.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		PaneMenu.setBorder(null);
		PaneMenu.setBounds(28, 159, 700, 269);
		frame.getContentPane().add(PaneMenu);

		JPanel panelmain = new JPanel();
		panelmain.setForeground(Color.WHITE);
		panelmain.setBorder(null);
		panelmain.setBackground(Color.WHITE);
		PaneMenu.addTab("DOUGHNUTS", null, panelmain, null);
		PaneMenu.setBackgroundAt(0, Color.WHITE);
		panelmain.setLayout(null);

		LabelDnImg1 = new JLabel(new ImageIcon(MENUIMG[0]));
		LabelDnImg1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		LabelDnImg1.setBounds(67, 26, 95, 95);
		panelmain.add(LabelDnImg1);
		LabelDnImg1.setSize(95, 95);

		dn1_count = new JSpinner();
		dn1_count.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		dn1_count.setBounds(63, 171, 81, 22);
		panelmain.add(dn1_count);

		dn1_menu = new JLabel("오리지널 글레이즈드");
		dn1_menu.setFont(new Font("돋움", Font.PLAIN, 12));
		dn1_menu.setBounds(63, 122, 119, 15);
		panelmain.add(dn1_menu);

		dn1_price = new JLabel("\\1,500");
		dn1_price.setFont(new Font("돋움", Font.PLAIN, 12));
		dn1_price.setBounds(88, 143, 59, 15);
		panelmain.add(dn1_price);

		JLabel dn2_menu = new JLabel("카라멜 글레이즈드");
		dn2_menu.setFont(new Font("돋움", Font.PLAIN, 12));
		dn2_menu.setBounds(225, 122, 119, 15);
		panelmain.add(dn2_menu);

		dn2_price = new JLabel("\\1,700");
		dn2_price.setFont(new Font("돋움", Font.PLAIN, 12));
		dn2_price.setBounds(248, 143, 59, 15);
		panelmain.add(dn2_price);

		dn2_count = new JSpinner();
		dn2_count.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		dn2_count.setBounds(225, 171, 81, 22);
		panelmain.add(dn2_count);

		LabelDnImg2 = new JLabel(new ImageIcon(MENUIMG[1]));
		LabelDnImg2.setBounds(218, 26, 95, 95);
		panelmain.add(LabelDnImg2);

		JLabel dn3_menu = new JLabel("초콜릿 아이스글레이즈드");
		dn3_menu.setFont(new Font("돋움", Font.PLAIN, 12));
		dn3_menu.setBounds(356, 122, 138, 15);
		panelmain.add(dn3_menu);

		LabelDnImg3 = new JLabel(new ImageIcon(MENUIMG[2]));
		LabelDnImg3.setBounds(368, 26, 95, 95);
		panelmain.add(LabelDnImg3);

		dn3_price = new JLabel("\\1,700");
		dn3_price.setFont(new Font("돋움", Font.PLAIN, 12));
		dn3_price.setBounds(403, 143, 59, 15);
		panelmain.add(dn3_price);

		dn3_count = new JSpinner();
		dn3_count.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		dn3_count.setBounds(381, 171, 81, 22);
		panelmain.add(dn3_count);

		LabelDnImg4 = new JLabel(new ImageIcon(MENUIMG[3]));
		LabelDnImg4.setHorizontalAlignment(SwingConstants.LEADING);
		LabelDnImg4.setBounds(528, 24, 95, 95);
		panelmain.add(LabelDnImg4);

		dn3_menu_1 = new JLabel("루돌프");
		dn3_menu_1.setHorizontalAlignment(SwingConstants.CENTER);
		dn3_menu_1.setFont(new Font("돋움", Font.PLAIN, 12));
		dn3_menu_1.setBounds(556, 122, 49, 15);
		panelmain.add(dn3_menu_1);

		dn3_price_1 = new JLabel("\\2,500");
		dn3_price_1.setFont(new Font("돋움", Font.PLAIN, 12));
		dn3_price_1.setBounds(556, 144, 59, 15);
		panelmain.add(dn3_price_1);

		dn4_count = new JSpinner();
		dn4_count.setBounds(540, 169, 81, 22);
		panelmain.add(dn4_count);
		LabelDnImg1.setVisible(true);

		JPanel panelcoffee = new JPanel();
		panelcoffee.setForeground(Color.WHITE);
		panelcoffee.setBorder(null);
		panelcoffee.setBackground(Color.WHITE);
		PaneMenu.addTab("COFFEE & DRINK", null, panelcoffee, null);
		panelcoffee.setLayout(null);

		cf1_menu = new JLabel("아이스 아메리카노");
		cf1_menu.setFont(new Font("돋움", Font.PLAIN, 12));
		cf1_menu.setBounds(60, 130, 119, 15);
		panelcoffee.add(cf1_menu);

		dn5_price = new JLabel("\\ 3,000");
		dn5_price.setFont(new Font("돋움", Font.PLAIN, 12));
		dn5_price.setBounds(85, 147, 59, 15);
		panelcoffee.add(dn5_price);

		cf1_count = new JSpinner();
		cf1_count.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cf1_count.setBounds(60, 167, 81, 22);
		panelcoffee.add(cf1_count);

		cf2_menu = new JLabel("아메리카노");
		cf2_menu.setHorizontalAlignment(SwingConstants.CENTER);
		cf2_menu.setFont(new Font("돋움", Font.PLAIN, 12));
		cf2_menu.setBounds(208, 131, 119, 15);
		panelcoffee.add(cf2_menu);

		dn6_price = new JLabel("\\ 3,700");
		dn6_price.setFont(new Font("돋움", Font.PLAIN, 12));
		dn6_price.setBounds(249, 147, 59, 15);
		panelcoffee.add(dn6_price);

		cf2_count = new JSpinner();
		cf2_count.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cf2_count.setBounds(224, 167, 81, 22);
		panelcoffee.add(cf2_count);

		cf3_menu = new JLabel("바닐라 라떼");
		cf3_menu.setHorizontalAlignment(SwingConstants.CENTER);
		cf3_menu.setFont(new Font("돋움", Font.PLAIN, 12));
		cf3_menu.setBounds(365, 130, 119, 15);
		panelcoffee.add(cf3_menu);

		dn7_price = new JLabel("\\ 4,400");
		dn7_price.setFont(new Font("돋움", Font.PLAIN, 12));
		dn7_price.setBounds(396, 147, 59, 15);
		panelcoffee.add(dn7_price);

		cf3_count = new JSpinner();
		cf3_count.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cf3_count.setBounds(383, 167, 81, 22);
		panelcoffee.add(cf3_count);

		LabelDnImg5 = new JLabel(new ImageIcon(MENUIMG[4]));
		LabelDnImg5.setBounds(54, 23, 95, 95);
		panelcoffee.add(LabelDnImg5);

		LabelDnImg6 = new JLabel(new ImageIcon(MENUIMG[5]));
		LabelDnImg6.setBounds(227, 23, 95, 95);
		panelcoffee.add(LabelDnImg6);

		LabelDnImg7 = new JLabel(new ImageIcon(MENUIMG[6]));
		LabelDnImg7.setBounds(376, 22, 95, 95);
		panelcoffee.add(LabelDnImg7);

		cf4_count = new JSpinner();
		cf4_count.setBounds(546, 167, 81, 22);
		panelcoffee.add(cf4_count);

		dn8_price = new JLabel("\\ 5,500");
		dn8_price.setFont(new Font("돋움", Font.PLAIN, 12));
		dn8_price.setBounds(557, 147, 59, 15);
		panelcoffee.add(dn8_price);

		cf4_menu = new JLabel("살구자두 스무디");
		cf4_menu.setHorizontalAlignment(SwingConstants.CENTER);
		cf4_menu.setFont(new Font("돋움", Font.PLAIN, 12));
		cf4_menu.setBounds(535, 130, 106, 15);
		panelcoffee.add(cf4_menu);

		LabelDnImg8 = new JLabel(new ImageIcon(MENUIMG[7]));
		LabelDnImg8.setBounds(535, 27, 95, 95);
		panelcoffee.add(LabelDnImg8);
		PaneMenu.setBackgroundAt(1, Color.WHITE);

		JButton btnOrder = new JButton("주문담기");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDonutsTableModel();
			}
		});
		btnOrder.setBackground(new Color(0, 128, 0));
		btnOrder.setBorder(null);
		btnOrder.setForeground(new Color(255, 255, 255));
		btnOrder.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnOrder.setBounds(510, 146, 102, 37);
		frame.getContentPane().add(btnOrder);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(28, 485, 700, 204);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("돋움", Font.PLAIN, 15));
		model = new DefaultTableModel(null, ORDER_COLUMN);

		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel LabelTotal = new JLabel("주문 금액  \\");
		LabelTotal.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		LabelTotal.setBounds(366, 699, 107, 37);
		frame.getContentPane().add(LabelTotal);

		textTotal = new JTextField();
		textTotal.setFont(new Font("돋움", Font.BOLD, 18));
		textTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textTotal.setBounds(485, 700, 130, 37);
		frame.getContentPane().add(textTotal);
		textTotal.setColumns(10);

		btnCancle = new JButton("전체취소");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllOrders();
			}
		});
		btnCancle.setForeground(Color.WHITE);
		btnCancle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnCancle.setBorder(null);
		btnCancle.setBackground(new Color(60, 179, 113));
		btnCancle.setBounds(625, 146, 102, 37);
		frame.getContentPane().add(btnCancle);

		btnSelectCancle = new JButton("선택취소");
		btnSelectCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMenu();
			}
		});
		btnSelectCancle.setForeground(Color.WHITE);
		btnSelectCancle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnSelectCancle.setBorder(null);
		btnSelectCancle.setBackground(new Color(51, 102, 0));
		btnSelectCancle.setBounds(637, 438, 80, 37);
		frame.getContentPane().add(btnSelectCancle);

		JButton btnpayment = new JButton("결제");
		btnpayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment();
			}
		});
		btnpayment.setForeground(new Color(255, 255, 0));
		btnpayment.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnpayment.setBorder(null);
		btnpayment.setBackground(new Color(51, 153, 0));
		btnpayment.setBounds(627, 698, 102, 37);
		frame.getContentPane().add(btnpayment);

		JTabbedPane tPane = new JTabbedPane();
		getContentPane().add(tPane);
		frame.setBounds(100, 100, 777, 804);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	protected void payment() {
		List<Donuts> list = new ArrayList<Donuts>();
		for (int i = 0; i < model.getRowCount(); i++) {
			Donuts listAdd = new Donuts((int) model.getValueAt(i, 0), 
											  model.getValueAt(i, 1).toString(),
										(int) model.getValueAt(i, 2), 
										(int) model.getValueAt(i, 3));
												list.add(listAdd);
		}
		dao.insert(list);

		deleteAllOrders();
	}

	private void addDonutsTableModel() {
		int ct[] = new int[9];
		try {
			ct[0] = (int) this.dn1_count.getValue();
			ct[1] = (int) this.dn2_count.getValue();
			ct[2] = (int) this.dn3_count.getValue();
			ct[3] = (int) this.dn4_count.getValue();
			ct[4] = (int) this.cf1_count.getValue();
			ct[5] = (int) this.cf2_count.getValue();
			ct[6] = (int) this.cf3_count.getValue();
			ct[7] = (int) this.cf4_count.getValue();

			for (int i = 0; i < 9; i++) {
				if (ct[i] < 1)
					continue;
				Donuts list = new Donuts(model.getRowCount() + 1, DNMENU[i], ct[i], PRICE[i]);
				Object[] rowData = { list.getNo(), list.getMenuName(), list.getCount(), list.getPrice(),
						list.getSum() };
				model.addRow(rowData);
			}
			setTotal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clearAll();
		}
	}

	private void setTotal() {
		int total = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			total += (int) model.getValueAt(i, 4);
		}
		textTotal.setText(total + "");
	}

	private void clearAll() {
		dn1_count.setValue(0);
		dn2_count.setValue(0);
		dn3_count.setValue(0);
		dn4_count.setValue(0);
		cf1_count.setValue(0);
		cf2_count.setValue(0);
		cf3_count.setValue(0);
		cf4_count.setValue(0);
	}

	protected void deleteAllOrders() {

		model.setNumRows(0);
		setTotal();

	}

	protected void deleteMenu() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(frame, "취소할 상품을 선택하세요");
			return;
		}

		model.removeRow(row);
		setTotal();

	}

} // end class
