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

import com.poo.controller.AlunoController;
import com.poo.model.Aluno;

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

public class AlunoFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Aluno> alunos;
	private int idTurma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoFrame frame = new AlunoFrame();
					frame.updateTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AlunoFrame(int idTurma) {
		this();
		this.idTurma = idTurma;
		updateTable();
	}

	/**
	 * Create the frame.
	 */
	public AlunoFrame() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNovaEscola = new JButton("Novo Aluno");
		btnNovaEscola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserirAlunoFrame frameInserirAluno = new InserirAlunoFrame(AlunoFrame.this.idTurma);
				frameInserirAluno.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent ev) {
						AlunoFrame.this.updateTable();
					}
				});
				frameInserirAluno.setVisible(true);
				
			}
		});
		
		JLabel lblEscolas = new JLabel("Alunos");
		
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
							Aluno aluno = alunos.get(i);
							
							String nome = table.getValueAt(i, 1).toString();
							aluno.setNome(nome);
							int idade = Integer.parseInt(table.getValueAt(i, 2).toString());
							aluno.setIdade(idade);
							int idTurma = Integer.parseInt(table.getValueAt(i,  3).toString());
							aluno.setIdTurma(idTurma);
							
							new AlunoController().update(aluno);
							JOptionPane.showMessageDialog(AlunoFrame.this, "Alterado com sucesso!");
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
							Aluno aluno = alunos.get(i);
							new AlunoController().delete(aluno);
							JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
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
							.addComponent(btnExcluir))
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
						.addComponent(btnExcluir))
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
				"Matricula", "Idade", "Nome", "ID_Turma"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, false
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

        List<Aluno> alunos = new AlunoController().readAlunosTurma(this.idTurma);
        this.alunos = alunos;
        int tam = alunos.size();

        for (int i = 0; i < tam; i++)
        {
            Aluno aluno = alunos.get(i);

            tTabela.addRow(new Object[]{1});

            table.setValueAt(aluno.getMatricula(), i, 0);
            table.setValueAt(aluno.getNome(), i, 1);
        	table.setValueAt(aluno.getIdade(), i, 2);
        	table.setValueAt(aluno.getIdTurma(), i, 3);
        }

    }
}
