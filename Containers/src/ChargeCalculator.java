import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChargeCalculator extends JFrame {
	private JPanel panel;
	private JTextField codeField = new JTextField("code");
	private JTextField destinationField = new JTextField("destination");
	private JTextField weightField = new JTextField("weight");
	private JTextField powerField = new JTextField("power");
	private JButton createBulkButton = new JButton("Create Bulk");
	private JButton createRefrButton = new JButton("Create Refr");
	private JButton button;
	private ArrayList<Ship> ships;
	private JList list = new JList();   //View
	
	public ChargeCalculator(ArrayList<Ship> someShips) {
		ships = someShips;
		DefaultListModel model = new DefaultListModel(); //MODEL
		for(Ship ship: ships)
			model.addElement(ship.getName());
		list.setModel(model);  //������� ���� �� ������� ���������
		
		panel = new JPanel();
		panel.add(codeField);
		panel.add(destinationField);
		panel.add(weightField);
		panel.add(powerField);
		panel.add(createBulkButton);
		panel.add(createRefrButton);

		button = new JButton("Calculate Total Charge");
		panel.add(button);
		panel.add(list);  //////////////////////////////////////
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		CreateButtonListener createListener = new CreateButtonListener();
		createBulkButton.addActionListener(createListener);
		createRefrButton.addActionListener(createListener);
			
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Charge Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//������ ��� �������� ��� ����������� ������
			
			String selectedShipName = (String) list.getSelectedValue();
			
			Ship selectedShip = null;
			for(Ship ship: ships)
				if(ship.getName().equals(selectedShipName))
					selectedShip = ship;
			
			double charge;
			charge = selectedShip.calculateTotalCharge();
			
			System.out.println("Total charge for ship: " 
			              + selectedShipName + " is: " + charge);
			
		}
		
	}
	
	class CreateButtonListener implements ActionListener {

		
		public void actionPerformed(ActionEvent arg0) {
			
			String code = codeField.getText();
			String destination = destinationField.getText();
			
			String selectedShipName = (String) list.getSelectedValue();
			
			Ship selectedShip = null;
			for(Ship ship: ships)
				if(ship.getName().equals(selectedShipName))
					selectedShip = ship;
			
			Container container;
			
			if(arg0.getSource().equals(createBulkButton)) {
				//���������� �� ������� createBulkButton
				String weightText = weightField.getText();
				double weight = Double.parseDouble(weightText);
				container = new Bulk(code, destination, weight);
			}
			else {
				//���������� �� ������� createRefrButton
				String powerText = powerField.getText();
				double power = Double.parseDouble(powerText);
				container = new Refridgerator(code, destination, power);
			}
			
			selectedShip.addContainer(container);
		}
		
	}
}
