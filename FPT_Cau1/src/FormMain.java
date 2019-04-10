import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormMain extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JTextField output;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain frame = new FormMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhpChui = new JLabel("Nh\u1EADp chu\u1ED7i");
		lblNhpChui.setBounds(10, 11, 71, 14);
		contentPane.add(lblNhpChui);
		
		input = new JTextField();
		input.setBounds(91, 8, 269, 20);
		contentPane.add(input);
		input.setColumns(10);
		
		JLabel lblThcHin = new JLabel("Th\u1EF1c hi\u1EC7n");
		lblThcHin.setBounds(10, 56, 71, 14);
		contentPane.add(lblThcHin);
		
		JComboBox comboBox = new JComboBox(); // đây là code tạo combobox , chúng ta thêm lựa chọn ở đoạn này!
		comboBox.setBounds(91, 53, 138, 20);
		// thêm lựa chọn cho combobox
		comboBox.addItem("Đếm từ");
		comboBox.addItem("Đếm từ trùng lặp");
		comboBox.addItem("Đảo chuỗi");
		
		// chú ý thêm lựa chọn trước hàm 'contentPane.add(comboBox);'
		contentPane.add(comboBox);
		
		JLabel lblKtQu = new JLabel("K\u1EBFt qu\u1EA3");
		lblKtQu.setBounds(10, 101, 54, 14);
		contentPane.add(lblKtQu);
		
		output = new JTextField();
		output.setBounds(89, 98, 271, 77);
		contentPane.add(output);
		output.setColumns(10);
		
		JButton btnNewButton = new JButton("View"); // code tạo button View
		btnNewButton.addMouseListener(new MouseAdapter() { // Code thêm sự kiện cho button đã tạo
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Các bạn sẽ viết công việc cần làm vào vùng này !!
				
				String chuoi = input.getText();
				
				//----dem tu 
				
				if(comboBox.getSelectedItem().toString().equals("Đếm từ")) { // phương thức kiểm tra giá trị combox được chọn là gì? 
					output.setText(""); // xóa ô kết quả sau khi thực hiện một phương thức
					int soTu = demTu(chuoi);
					output.setText("Số từ trong chuỗi là : "+soTu); // phương thức setText để gán giá trị vào ô Jtext
				}else
					if(comboBox.getSelectedItem().toString().equals("Đếm từ trùng lặp")) {
						output.setText("");
						//----dem trung lap tu
						demTuTrungLap(chuoi); 
					}else
						if(comboBox.getSelectedItem().toString().equals("Đảo chuỗi")) {
							output.setText("");
							//----dao chuoi
							daoChuoi(chuoi);
						}	
			}
		});
		btnNewButton.setBounds(74, 214, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// sự kiện cho button reset
				// --------
				input.setText("");
				output.setText("");
			}
		});
		btnNewButton_1.setBounds(184, 214, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// sự kiện cho button exit
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(298, 214, 89, 23);
		contentPane.add(btnNewButton_2);
	}
	
	
	public int demTu(String input) { // input là dữ liệu người dùng nhập vào
		String[] arrInput = input.split(" "); // tạo đối tượng String dạng mảng có tên arrInput để nhận kết quả sau khi tách chuỗi input
		return arrInput.length;
	}
	
	
	public void demTuTrungLap(String input) { // chúng ta thực hiện luôn trong hàm việc gán kết quả cho ô output nên không cần return nữa!!
		String[] arrInput = input.split(" "); // 
		
		for(int i = 0;i< arrInput.length ; i++) {
			if(!kiemTraTrungLap(i, arrInput)) { // nếu từ đang xét chưa được đếm trước đó thì thực hiện đếm
				output.setText(output.getText()+ "\n" + arrInput[i] +" :" ); // in từ đang xét vào ô output trước khi đếm
				int dem = 0; // tạo biến đếm từ
				for(int j = i;j<arrInput.length ;j++) {
					if(arrInput[i].equals(arrInput[j])) {
						dem++;
					}
				}
				
				output.setText(output.getText() + dem  ); // lưu kết quả đếm
			}else {
				continue; // nếu từ đã được đếm thì bỏ qua
			}
		}
		
	}
	
	public boolean kiemTraTrungLap(int viTriHienTai, String[] chuoi) { // phương thức này để kiểm tra từ đang xử lý đã trùng hay chưa?
		for(int i = 0 ; i< viTriHienTai ; i++) {
			if(chuoi[i].equals(chuoi[viTriHienTai])) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public void daoChuoi(String input) {
		String[] arrInput = input.split(" ");
		
		for(int i = 0, j=arrInput.length-1;i<j;i++,j--) {
			String tg = arrInput[i]; 
			arrInput[i] = arrInput[j];
			arrInput[j] = tg; 
		}
		
		for(int i = 0;i<arrInput.length;i++) {
			output.setText(output.getText() + arrInput[i] + " ");
		}
	}
	
}
