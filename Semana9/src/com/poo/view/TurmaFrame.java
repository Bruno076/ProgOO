package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.poo.controller.EscolaController;
import com.poo.controller.TurmaController;
import com.poo.model.Escola;
import com.poo.model.Turma;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class TurmaFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Turma> turmas;
	private int idEscola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TurmaFrame frame = new TurmaFrame();
					frame.updateTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TurmaFrame(int idEscola) {
		this();
		this.idEscola = idEscola;
		updateTable();
	}

	/**
	 * Create the frame.
	 */
	public TurmaFrame() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNovaEscola = new JButton("Nova Turma");
		btnNovaEscola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserirTurmaFrame frameInserirTurma = new InserirTurmaFrame(TurmaFrame.this.idEscola);
				frameInserirTurma.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent ev) {
						TurmaFrame.this.updateTable();
					}
				});
				frameInserirTurma.setVisible(true);
				
			}
		});
		
		JLabel lblEscolas = new JLabel("Turmas");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAtualizar = new JButton("Alterar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ListSelectionModel selecao = table.getSelectionModel();
				// se a seleção de linha tiver pelo menos uma linha
				if (!selecao.isSelectionEmpty()) {
					int minIndex = selecao.getMinSelectionIndex();
					int maxIndex = selecao.getMaxSelectionIndex();
					
					for (int i = minIndex; i <= maxIndex; i++) {
						if (selecao.isSelectedIndex(i)) {
							Turma turma = turmas.get(i);
							String ano = table.getValueAt(i, 1).toString();
							turma.setAno(ano);
							new TurmaController().update(turma);
							JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
						}
					}
				}
				
				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListSelectionModel selecao = table.getSelectionModel();
				// se a seleção de linha tiver pelo menos uma linha
				if (!selecao.isSelectionEmpty()) {
					int minIndex = selecao.getMinSelectionIndex();
					int maxIndex = selecao.getMaxSelectionIndex();
					
					for (int i = minIndex; i <= maxIndex; i++) {
						if (selecao.isSelectedIndex(i)) {
							Turma turma = turmas.get(i);
							new TurmaController().delete(turma);
							JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
						}
					}
					updateTable();
				}
				
			}
		});
		
		JButton btnTurmas = new JButton("Alunos");
		btnTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListSelectionModel selecao = table.getSelectionModel();
				// se a seleção de linha tiver pelo menos uma linha
				if (!selecao.isSelectionEmpty()) {
					int minIndex = selecao.getMinSelectionIndex();
					int maxIndex = selecao.getMaxSelectionIndex();
					
					for (int i = minIndex; i <= maxIndex; i++) {
						if (selecao.isSelectedIndex(i)) {
							Turma turma = turmas.get(i);
							AlunoFrame alunoFrame = new AlunoFrame(turma.getIdTurma());
							alunoFrame.setVisible(true);
						}
					}
					updateTable();
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNovaEscola)
							.addGap(18)
							.addComponent(btnAtualizar)
							.addGap(18)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnTurmas))
						.addComponent(lblEscolas)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblEscolas)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovaEscola)
						.addComponent(btnAtualizar)
						.addComponent(btnExcluir)
						.addComponent(btnTurmas))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ano", "ID_Escola"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
	}
	
	public void updateTable(){
        DefaultTableModel tTabela = (DefaultTableModel) table.getModel();
        tTabela.setNumRows(0);

        List<Turma> turmas = new TurmaController().readTurmasEscola(this.idEscola);
        this.turmas = turmas;
        int tam = turmas.size();

        for (int i = 0; i < tam; i++)
        {
            Turma turma = turmas.get(i);

            tTabela.addRow(new Object[]{1});

            table.setValueAt(turma.getIdTurma(), i, 0);
            table.setValueAt(turma.getAno(), i, 1);
        	table.setValueAt(turma.getIdEscola(), i, 2);
        }

    }
}
