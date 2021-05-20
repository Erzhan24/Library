import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindBook extends JFrame {
    static FindBook frame;
    private JPanel contentPane;
    private JTextField textField;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new FindBook();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FindBook() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 516, 330);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblBook = new JLabel("Find Book");
        lblBook.setForeground(Color.GRAY);
        lblBook.setFont(new Font("Tahoma", Font.PLAIN, 18));





        textField = new JTextField();
        textField.setColumns(10);



        JButton btnBook = new JButton("Find Book");
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name=textField.getText();

                boolean i=FindBookDao.findBook(name);
                if(true){
                    JOptionPane.showMessageDialog(FindBook.this,"Book found successfully!");
                    LibrarianSuccess.main(new String[]{});
                    frame.dispose();

                }else{
                    JOptionPane.showMessageDialog(FindBook.this,"Sorry, unable to find book!");
                }
            }
        });



        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibrarianSuccess.main(new String[]{});
                frame.dispose();
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(36)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)

                                        .addComponent(lblBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                                .addGap(56)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)

                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(139, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(210, Short.MAX_VALUE)
                                .addComponent(btnBook, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                .addGap(176))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(205, Short.MAX_VALUE)
                                .addComponent(lblBook)
                                .addGap(187))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(19)

                                .addContainerGap(294, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(355, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addGap(46))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblBook)
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBook)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(34)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)

                                       )

                                .addComponent(btnBook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(23)
                                .addComponent(btnBack)
                                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)

                                .addGap(72))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
