package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class MainWindow {

	private JFrame frame;
	private JPanel mainWin;
	private JPanel addRel;
	private JPanel addPer;
	private JPanel addPro;
	private JPanel addCas;
	private JPanel disA;
	private JPanel disC;
	private JPanel disCC;
	private JPanel sbN;
	private JPanel addCWin;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_5;
	private JLabel label;
	private JTextField relName;
	private JTextField relMob;
	private JTextField relMail;
	private JTextField relDOB;
	private JTextField relDOLM;
	private JLabel label_2;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField perMail;
	private JTextField perMob;
	private JTextField perName;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField proMail;
	private JTextField proMob;
	private JTextField proName;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField casMail;
	private JTextField casMob;
	private JTextField casName;
	private JPanel cDet;
	private JTextField searchC;
	private JTextField perCon;
	private JTextField perDate;
	private JTextField perEve;
	private JTextField proInt;
	private JTextField casWhen;
	private JTextField casWhere;
	private JTextField casWhat;
	private JTextField casInfo;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTextPane detPane;
	private JPanel CCPane;
	private JPanel ACPane;
	private JPanel sbNPane;
	private JButton btnBack_6;
	private JButton btnBack_7;
	private JButton btnBack_1;
	private JButton btnDelete;
	public static ArrayList<Relative> relatives=new ArrayList<Relative>();
	public static ArrayList<PersonalFriend> pFriends=new ArrayList<PersonalFriend>();
	public static ArrayList<ProfessionalFriend> prFriends=new ArrayList<ProfessionalFriend>();
	public static ArrayList<Casual> casuals=new ArrayList<Casual>();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainWindow();
					ContactList.getContacts();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setVisible(true);
		
		mainWin = new JPanel();
		mainWin.setVisible(true);
		frame.getContentPane().add(mainWin, "name_51758697553536");
		mainWin.setLayout(null);
		
		label = new JLabel("CONTACT LIST");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 23, 414, 25);
		mainWin.add(label);
		
		button = new JButton("Add Contact");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWin.setVisible(false);
				addCWin.setVisible(true);
			}
		});
		button.setBounds(45, 104, 134, 23);
		mainWin.add(button);
		
		button_1 = new JButton("Display All");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWin.setVisible(false);
				ACPane.removeAll();
				ACPane.updateUI();
				for(int i=0;i<relatives.size();i++)
				{
					JButton button=new JButton(relatives.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							disA.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							Relative relative=relatives.get(id);
							detPane.setText("Type: Relative\nName: "+relative.name+"\nMobile: "+relative.mobile+"\nEmail: "+relative.email+"\n"
									+"Birth Day: "+relative.birth_day.toString()+"\nLast Met: "+relative.last_meet);
							cDet.setVisible(true);
							btnDelete.putClientProperty("type", 0);
							btnDelete.putClientProperty("id", id);
						}
					});
					button.putClientProperty("id", i);
					ACPane.add(button);
				}
				for(int i=0;i<pFriends.size();i++)
				{
					JButton button=new JButton(pFriends.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							disA.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							PersonalFriend pFriend=pFriends.get(id);
							detPane.setText("Type: Personal Acquaintance\nName: "+pFriend.name+"\nMobile: "+pFriend.mobile+"\nEmail: "+pFriend.email+"\n"
									+"Context: "+pFriend.context+"\nDate Met: "+pFriend.date_met+"\nEvents: "+pFriend.events);
							cDet.setVisible(true);
							btnDelete.putClientProperty("type", 1);
							btnDelete.putClientProperty("id", id);
						}
					});
					button.putClientProperty("id", i);
					ACPane.add(button);
				}
				for(int i=0;i<prFriends.size();i++)
				{
					JButton button=new JButton(prFriends.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							disA.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							ProfessionalFriend prFriend=prFriends.get(id);
							detPane.setText("Type: Professional Acquaintance\nName: "+prFriend.name+"\nMobile: "+prFriend.mobile+"\nEmail: "
							+prFriend.email+"\nInterests: "+prFriend.interests);
							cDet.setVisible(true);
							btnDelete.putClientProperty("type", 2);
							btnDelete.putClientProperty("id", id);
						}
					});
					button.putClientProperty("id", i);
					ACPane.add(button);
				}
				for(int i=0;i<casuals.size();i++)
				{
					JButton button=new JButton(casuals.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							disA.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							Casual casual=casuals.get(id);
							detPane.setText("Type: Casual Acquaintance\nName: "+casual.name+"\nMobile: "+casual.mobile+"\nEmail: "+casual.email+"\n"
									+"What: "+casual.what+"\nWhere: "+casual.where+"\nWhen: "+casual.when.toString()+"\nInfo: "+casual.info);
							cDet.setVisible(true);
							btnDelete.putClientProperty("type", 3);
							btnDelete.putClientProperty("id", id);
						}
					});
					button.putClientProperty("id", i);
					ACPane.add(button);
				}
				btnBack_1.putClientProperty("type",1);
				disA.setVisible(true);
			}
		});
		button_1.setBounds(47, 155, 134, 23);
		mainWin.add(button_1);
		
		button_2 = new JButton("Display");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWin.setVisible(false);
				disCC.setVisible(true);
			}
		});
		button_2.setBounds(257, 103, 145, 23);
		mainWin.add(button_2);
		
		button_3 = new JButton("Search by Name");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWin.setVisible(false);
				sbN.setVisible(true);
			}
		});
		button_3.setBounds(259, 153, 145, 23);
		mainWin.add(button_3);
		
		button_5 = new JButton("CLOSE");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactList.saveContacts();
				frame.dispose();
			}
		});
		button_5.setBounds(160, 210, 145, 23);
		mainWin.add(button_5);
		
		cDet = new JPanel();
		cDet.setVisible(false);
		frame.getContentPane().add(cDet, "name_4456455347074");
		cDet.setLayout(null);
		
		detPane = new JTextPane();
		detPane.setBounds(10, 11, 414, 195);
		scrollPane_3 = new JScrollPane(detPane);
		scrollPane_3.setBounds(10, 11, 414, 195);
		cDet.add(scrollPane_3);
		
		btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cDet.setVisible(false);
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("type");
				if(id==0)
					disC.setVisible(true);
				else if(id==1)
					disA.setVisible(true);
				else
					sbN.setVisible(true);
			}
		});
		btnBack_1.setBounds(10, 227, 123, 23);
		cDet.add(btnBack_1);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cDet.setVisible(false);
				JButton button=(JButton)e.getSource();
				int type=(int)button.getClientProperty("type");
				int id=(int)button.getClientProperty("id");
				switch (type) {
				case 0:
					relatives.remove(id);
					break;
				case 1:
					pFriends.remove(id);
					break;
				case 2:
					prFriends.remove(id);
					break;
				case 3:
					casuals.remove(id);
					break;
				}
				mainWin.setVisible(true);
			}
		});
		btnDelete.setBounds(306, 227, 118, 23);
		cDet.add(btnDelete);
		
		addCWin = new JPanel();
		addCWin.setVisible(false);
		frame.getContentPane().add(addCWin, "name_51758704507326");
		addCWin.setLayout(null);
		
		JLabel lblSelectCatogary = new JLabel("Select Catogary");
		lblSelectCatogary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCatogary.setBounds(10, 11, 414, 23);
		addCWin.add(lblSelectCatogary);
		
		JButton btnRelative = new JButton("Relative");
		btnRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCWin.setVisible(false);
				addRel.setVisible(true);
			}
		});
		btnRelative.setBounds(53, 62, 113, 23);
		addCWin.add(btnRelative);
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCWin.setVisible(false);
				addPer.setVisible(true);
			}
		});
		btnPersonal.setBounds(265, 62, 113, 23);
		addCWin.add(btnPersonal);
		
		JButton btnProfessional = new JButton("Professional");
		btnProfessional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCWin.setVisible(false);
				addPro.setVisible(true);
			}
		});
		btnProfessional.setBounds(53, 144, 113, 23);
		addCWin.add(btnProfessional);
		
		JButton btnCasula = new JButton("Casual");
		btnCasula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCWin.setVisible(false);
				addCas.setVisible(true);
			}
		});
		btnCasula.setBounds(265, 144, 113, 23);
		addCWin.add(btnCasula);
		
		btnBack_6 = new JButton("Back");
		btnBack_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCWin.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		btnBack_6.setBounds(10, 227, 98, 23);
		addCWin.add(btnBack_6);
		
		addRel = new JPanel();
		addRel.setVisible(false);
		frame.getContentPane().add(addRel, "name_51815940506842");
		addRel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(58, 40, 111, 14);
		addRel.add(lblName);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(58, 79, 111, 14);
		addRel.add(lblMobile);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(58, 118, 111, 14);
		addRel.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(58, 156, 111, 14);
		addRel.add(lblDateOfBirth);
		
		JLabel lblDateOfLast = new JLabel("Date of Last Meet:");
		lblDateOfLast.setBounds(58, 193, 111, 14);
		addRel.add(lblDateOfLast);
		
		relName = new JTextField();
		relName.setBounds(179, 37, 200, 20);
		addRel.add(relName);
		relName.setColumns(10);
		
		relMob = new JTextField();
		relMob.setBounds(179, 76, 200, 20);
		addRel.add(relMob);
		relMob.setColumns(10);
		
		relMail = new JTextField();
		relMail.setColumns(10);
		relMail.setBounds(179, 115, 200, 20);
		addRel.add(relMail);
		
		relDOB = new JTextField();
		relDOB.setColumns(10);
		relDOB.setBounds(179, 153, 200, 20);
		addRel.add(relDOB);
		
		relDOLM = new JTextField();
		relDOLM.setColumns(10);
		relDOLM.setBounds(179, 190, 200, 20);
		addRel.add(relDOLM);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRel.setVisible(false);
				addCWin.setVisible(true);
			}
		});
		btnBack_2.setBounds(10, 227, 111, 23);
		addRel.add(btnBack_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relative relative=new Relative();
				relative.name=relName.getText();
				relative.mobile=relMob.getText();
				relative.email=relMail.getText();
				String date[]=relDOB.getText().split(" ");
				relative.birth_day=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				date=relDOLM.getText().split(" ");
				relative.last_meet=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				relatives.add(relative);
				addRel.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		btnAdd.setBounds(335, 227, 89, 23);
		addRel.add(btnAdd);
		
		addPer = new JPanel();
		addPer.setVisible(false);
		frame.getContentPane().add(addPer, "name_51835385870134");
		addPer.setLayout(null);
		
		label_3 = new JLabel("Name:");
		label_3.setBounds(49, 14, 111, 14);
		addPer.add(label_3);
		
		label_4 = new JLabel("Mobile");
		label_4.setBounds(49, 49, 111, 14);
		addPer.add(label_4);
		
		label_5 = new JLabel("Email:");
		label_5.setBounds(49, 84, 111, 14);
		addPer.add(label_5);
		
		perMail = new JTextField();
		perMail.setColumns(10);
		perMail.setBounds(170, 81, 200, 20);
		addPer.add(perMail);
		
		perMob = new JTextField();
		perMob.setColumns(10);
		perMob.setBounds(170, 46, 200, 20);
		addPer.add(perMob);
		
		perName = new JTextField();
		perName.setColumns(10);
		perName.setBounds(170, 11, 200, 20);
		addPer.add(perName);
		
		JLabel lblContext = new JLabel("Context:");
		lblContext.setBounds(49, 122, 111, 14);
		addPer.add(lblContext);
		
		JLabel lblDateMetddMm = new JLabel("Date Met(d m y):");
		lblDateMetddMm.setBounds(49, 160, 111, 14);
		addPer.add(lblDateMetddMm);
		
		JLabel lblEvents = new JLabel("Events:");
		lblEvents.setBounds(49, 201, 111, 14);
		addPer.add(lblEvents);
		
		perCon = new JTextField();
		perCon.setBounds(170, 119, 200, 20);
		addPer.add(perCon);
		perCon.setColumns(10);
		
		perDate = new JTextField();
		perDate.setBounds(170, 157, 200, 20);
		addPer.add(perDate);
		perDate.setColumns(10);
		
		perEve = new JTextField();
		perEve.setBounds(170, 198, 200, 20);
		addPer.add(perEve);
		perEve.setColumns(10);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPer.setVisible(false);
				addCWin.setVisible(true);
			}
		});
		btnBack_3.setBounds(0, 238, 111, 23);
		addPer.add(btnBack_3);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalFriend pFriend=new PersonalFriend();
				pFriend.name=perName.getText();
				pFriend.mobile=perMob.getText();
				pFriend.email=perMail.getText();
				pFriend.context=perCon.getText();
				pFriend.events=perEve.getText();
				String date[]=perDate.getText().split(" ");
				pFriend.date_met=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				pFriends.add(pFriend);
				addPer.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		btnAdd_1.setBounds(330, 238, 104, 23);
		addPer.add(btnAdd_1);
		
		addPro = new JPanel();
		addPro.setVisible(false);
		frame.getContentPane().add(addPro, "name_51860224266037");
		addPro.setLayout(null);
		
		label_6 = new JLabel("Name:");
		label_6.setBounds(62, 26, 111, 14);
		addPro.add(label_6);
		
		label_7 = new JLabel("Mobile");
		label_7.setBounds(62, 65, 111, 14);
		addPro.add(label_7);
		
		label_8 = new JLabel("Email:");
		label_8.setBounds(62, 104, 111, 14);
		addPro.add(label_8);
		
		proMail = new JTextField();
		proMail.setColumns(10);
		proMail.setBounds(183, 101, 200, 20);
		addPro.add(proMail);
		
		proMob = new JTextField();
		proMob.setColumns(10);
		proMob.setBounds(183, 62, 200, 20);
		addPro.add(proMob);
		
		proName = new JTextField();
		proName.setColumns(10);
		proName.setBounds(183, 23, 200, 20);
		addPro.add(proName);
		
		JLabel lblInterests = new JLabel("Interests:");
		lblInterests.setBounds(62, 151, 111, 14);
		addPro.add(lblInterests);
		
		proInt = new JTextField();
		proInt.setBounds(183, 148, 200, 20);
		addPro.add(proInt);
		proInt.setColumns(10);
		
		JButton btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPro.setVisible(false);
				addCWin.setVisible(true);
			}
		});
		btnBack_4.setBounds(10, 227, 105, 23);
		addPro.add(btnBack_4);
		
		JButton btnAdd_2 = new JButton("Add");
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessionalFriend prFriend=new ProfessionalFriend();
				prFriend.name=proName.getText();
				prFriend.mobile=proMob.getText();
				prFriend.email=proMail.getText();
				prFriend.interests=proInt.getText();
				prFriends.add(prFriend);
				addPro.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		btnAdd_2.setBounds(324, 227, 100, 23);
		addPro.add(btnAdd_2);
		
		addCas = new JPanel();
		addCas.setVisible(false);
		frame.getContentPane().add(addCas, "name_51868642812699");
		addCas.setLayout(null);
		
		label_9 = new JLabel("Name:");
		label_9.setBounds(49, 14, 111, 14);
		addCas.add(label_9);
		
		label_10 = new JLabel("Mobile");
		label_10.setBounds(49, 42, 111, 14);
		addCas.add(label_10);
		
		label_11 = new JLabel("Email:");
		label_11.setBounds(49, 70, 111, 14);
		addCas.add(label_11);
		
		casMail = new JTextField();
		casMail.setColumns(10);
		casMail.setBounds(170, 67, 200, 20);
		addCas.add(casMail);
		
		casMob = new JTextField();
		casMob.setColumns(10);
		casMob.setBounds(170, 39, 200, 20);
		addCas.add(casMob);
		
		casName = new JTextField();
		casName.setColumns(10);
		casName.setBounds(170, 11, 200, 20);
		addCas.add(casName);
		
		JLabel lblWhen = new JLabel("When:");
		lblWhen.setBounds(49, 105, 111, 14);
		addCas.add(lblWhen);
		
		JLabel lblWhere = new JLabel("Where:");
		lblWhere.setBounds(49, 137, 111, 14);
		addCas.add(lblWhere);
		
		JLabel lblWhat = new JLabel("What:");
		lblWhat.setBounds(49, 170, 111, 14);
		addCas.add(lblWhat);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setBounds(49, 204, 111, 14);
		addCas.add(lblInfo);
		
		casWhen = new JTextField();
		casWhen.setBounds(170, 102, 200, 20);
		addCas.add(casWhen);
		casWhen.setColumns(10);
		
		casWhere = new JTextField();
		casWhere.setColumns(10);
		casWhere.setBounds(170, 134, 200, 20);
		addCas.add(casWhere);
		
		casWhat = new JTextField();
		casWhat.setColumns(10);
		casWhat.setBounds(170, 167, 200, 20);
		addCas.add(casWhat);
		
		casInfo = new JTextField();
		casInfo.setColumns(10);
		casInfo.setBounds(170, 201, 200, 20);
		addCas.add(casInfo);
		
		JButton btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCas.setVisible(false);
				addCWin.setVisible(true);
			}
		});
		btnBack_5.setBounds(10, 229, 120, 23);
		addCas.add(btnBack_5);
		
		JButton btnAdd_3 = new JButton("Add");
		btnAdd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Casual casual=new Casual();
				casual.name=casName.getText();
				casual.mobile=casMob.getText();
				casual.email=casMail.getText();
				casual.what=casWhat.getText();
				casual.where=casWhere.getText();
				casual.info=casInfo.getText();
				String date[]=casWhen.getText().split(" ");
				casual.when=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				casuals.add(casual);
				addCas.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		btnAdd_3.setBounds(313, 229, 111, 23);
		addCas.add(btnAdd_3);
		
		disCC = new JPanel();
		disCC.setVisible(false);
		frame.getContentPane().add(disCC, "name_52087564230723");
		disCC.setLayout(null);
		
		label_2 = new JLabel("Select Catogary");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 36, 414, 23);
		disCC.add(label_2);
		
		button_10 = new JButton("Relative");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disCC.setVisible(false);
				CCPane.removeAll();
				CCPane.updateUI();
				for(int i=0;i<relatives.size();i++)
				{
					JButton button=new JButton(relatives.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							disC.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							Relative relative=relatives.get(id);
							detPane.setText("Name: "+relative.name+"\nMobile: "+relative.mobile+"\nEmail: "+relative.email+"\n"
									+"Birth Day: "+relative.birth_day.toString()+"\nLast Met: "+relative.last_meet);
							cDet.setVisible(true);
						}
					});
					button.putClientProperty("id", i);
					CCPane.add(button);
					btnBack_1.putClientProperty("type",0);
					btnDelete.putClientProperty("type", 0);
					btnDelete.putClientProperty("id", i);
				}
				disC.setVisible(true);
			}
		});
		button_10.setBounds(53, 87, 113, 23);
		disCC.add(button_10);
		
		button_11 = new JButton("Personal");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disCC.setVisible(false);
				CCPane.removeAll();
				CCPane.updateUI();
				for(int i=0;i<pFriends.size();i++)
				{
					JButton button=new JButton(pFriends.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							disC.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							PersonalFriend pFriend=pFriends.get(id);
							detPane.setText("Name: "+pFriend.name+"\nMobile: "+pFriend.mobile+"\nEmail: "+pFriend.email+"\n"
									+"Context: "+pFriend.context+"\nDate Met: "+pFriend.date_met+"\nEvents: "+pFriend.events);
							cDet.setVisible(true);
						}
					});
					button.putClientProperty("id", i);
					CCPane.add(button);
					btnBack_1.putClientProperty("type", 0);
					btnDelete.putClientProperty("type", 1);
					btnDelete.putClientProperty("id", i);
				}
				disC.setVisible(true);
			}
		});
		button_11.setBounds(265, 87, 113, 23);
		disCC.add(button_11);
		
		button_12 = new JButton("Casual");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disCC.setVisible(false);
				CCPane.removeAll();
				CCPane.updateUI();
				for(int i=0;i<casuals.size();i++)
				{
					JButton button=new JButton(casuals.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							disC.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							Casual casual=casuals.get(id);
							detPane.setText("Name: "+casual.name+"\nMobile: "+casual.mobile+"\nEmail: "+casual.email+"\n"
									+"What: "+casual.what+"\nWhere: "+casual.where+"\nWhen: "+casual.when.toString()+"\nInfo: "+casual.info);
							cDet.setVisible(true);
						}
					});
					button.putClientProperty("id", i);
					CCPane.add(button);
					btnBack_1.putClientProperty("type", 0);
					btnDelete.putClientProperty("type", 3);
					btnDelete.putClientProperty("id", i);
				}
				disC.setVisible(true);
			}
		});
		button_12.setBounds(265, 169, 113, 23);
		disCC.add(button_12);
		
		button_13 = new JButton("Professional");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disCC.setVisible(false);
				CCPane.removeAll();
				CCPane.updateUI();
				for(int i=0;i<prFriends.size();i++)
				{
					JButton button=new JButton(prFriends.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							disC.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							ProfessionalFriend prFriend=prFriends.get(id);
							detPane.setText("Name: "+prFriend.name+"\nMobile: "+prFriend.mobile+"\nEmail: "+prFriend.email+"\n"
									+"Interests: "+prFriend.interests);
							cDet.setVisible(true);
						}
					});
					button.putClientProperty("id", i);
					CCPane.add(button);
					btnBack_1.putClientProperty("type", 0);
					btnDelete.putClientProperty("type", 2);
					btnDelete.putClientProperty("id", i);
				}
				disC.setVisible(true);
			}
		});
		button_13.setBounds(53, 169, 113, 23);
		disCC.add(button_13);
		
		btnBack_7 = new JButton("Back");
		btnBack_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disCC.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		btnBack_7.setBounds(10, 227, 105, 23);
		disCC.add(btnBack_7);
		
		disC = new JPanel();
		disC.setVisible(false);
		frame.getContentPane().add(disC, "name_52118236374980");
		disC.setLayout(null);
		
		CCPane = new JPanel();
		CCPane.setBounds(10, 11, 414, 208);
		scrollPane = new JScrollPane(CCPane);
		CCPane.setLayout(new BoxLayout(CCPane, BoxLayout.Y_AXIS));
		scrollPane.setBounds(10, 11, 414, 208);
		disC.add(scrollPane);
		
		JButton button_6 = new JButton("Back");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disC.setVisible(false);
				disCC.setVisible(true);
			}
		});
		button_6.setBounds(10, 227, 117, 23);
		disC.add(button_6);
		
		disA = new JPanel();
		disA.setVisible(false);
		frame.getContentPane().add(disA, "name_52168394371539");
		disA.setLayout(null);
		
		ACPane = new JPanel();
		ACPane.setBounds(10, 11, 414, 208);
		scrollPane_1 = new JScrollPane(ACPane);
		ACPane.setLayout(new BoxLayout(ACPane, BoxLayout.Y_AXIS));
		scrollPane_1.setBounds(10, 11, 414, 208);
		disA.add(scrollPane_1);
		
		JButton button_7 = new JButton("Back");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disA.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		button_7.setBounds(10, 227, 117, 23);
		disA.add(button_7);
				
		sbN = new JPanel();
		sbN.setVisible(false);
		frame.getContentPane().add(sbN, "name_52187335052002");
		sbN.setLayout(null);
		
		searchC = new JTextField();
		searchC.setBounds(10, 11, 301, 20);
		sbN.add(searchC);
		searchC.setColumns(10);
		
		sbNPane = new JPanel();
		sbNPane.setBounds(10, 42, 414, 178);
		scrollPane_2 = new JScrollPane(sbNPane);
		sbNPane.setLayout(new BoxLayout(sbNPane, BoxLayout.Y_AXIS));
		scrollPane_2.setBounds(10, 42, 414, 178);
		sbN.add(scrollPane_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbN.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		btnBack.setBounds(10, 231, 123, 23);
		sbN.add(btnBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=searchC.getText().toLowerCase();
				sbNPane.removeAll();
				sbNPane.updateUI();
				for(int i=0;i<relatives.size();i++)
				{
					if(!relatives.get(i).name.toLowerCase().contains(name)) continue;
					JButton button=new JButton(relatives.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							sbN.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							Relative relative=relatives.get(id);
							detPane.setText("Type: Relative\nName: "+relative.name+"\nMobile: "+relative.mobile+"\nEmail: "+relative.email+"\n"
									+"Birth Day: "+relative.birth_day.toString()+"\nLast Met: "+relative.last_meet);
							cDet.setVisible(true);
							btnDelete.putClientProperty("type", 0);
							btnDelete.putClientProperty("id", id);
						}
					});
					button.putClientProperty("id", i);
					sbNPane.add(button);
				}
				for(int i=0;i<pFriends.size();i++)
				{
					if(!pFriends.get(i).name.toLowerCase().contains(name)) continue;
					JButton button=new JButton(pFriends.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							sbN.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							PersonalFriend pFriend=pFriends.get(id);
							detPane.setText("Type: Personal Acquaintance\nName: "+pFriend.name+"\nMobile: "+pFriend.mobile+"\nEmail: "+
							pFriend.email+"\nContext: "+pFriend.context+"\nDate Met: "+pFriend.date_met+"\nEvents: "+pFriend.events);
							cDet.setVisible(true);
							btnDelete.putClientProperty("type", 1);
							btnDelete.putClientProperty("id", id);
						}
					});
					button.putClientProperty("id", i);
					sbNPane.add(button);
				}
				for(int i=0;i<prFriends.size();i++)
				{
					if(!prFriends.get(i).name.toLowerCase().contains(name)) continue;
					JButton button=new JButton(prFriends.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							sbN.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							ProfessionalFriend prFriend=prFriends.get(id);
							detPane.setText("Type: Professional Acquaintance\nName: "+prFriend.name+"\nMobile: "+prFriend.mobile+"\nEmail: "
							+prFriend.email+"\nInterests: "+prFriend.interests);
							cDet.setVisible(true);
							btnDelete.putClientProperty("type", 2);
							btnDelete.putClientProperty("id", id);
						}
					});
					button.putClientProperty("id", i);
					sbNPane.add(button);
				}
				for(int i=0;i<casuals.size();i++)
				{
					if(!casuals.get(i).name.toLowerCase().contains(name)) continue;
					JButton button=new JButton(casuals.get(i).name);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							sbN.setVisible(false);
							JButton button=(JButton)e.getSource();
							int id=(int)button.getClientProperty("id");
							Casual casual=casuals.get(id);
							detPane.setText("Type: Casual Acquaintance\nName: "+casual.name+"\nMobile: "+casual.mobile+"\nEmail: "+casual.email+"\n"
									+"What: "+casual.what+"\nWhere: "+casual.where+"\nWhen: "+casual.when.toString()+"\nInfo: "+casual.info);
							cDet.setVisible(true);
							btnDelete.putClientProperty("type", 3);
							btnDelete.putClientProperty("id", id);
						}
					});
					button.putClientProperty("id", i);
					sbNPane.add(button);
				}
				btnBack_1.putClientProperty("type",3);
			}
		});
		btnSearch.setBounds(335, 10, 89, 23);
		sbN.add(btnSearch);
	}
}
