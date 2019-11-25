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
import com.poo.model.Escola;

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

public class EscolaFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Escola> escolas;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.updateTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public EscolaFrame() {
		escolas = new EscolaController().readAll();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNovaEscola = new JButton("Nova Escola");
		btnNovaEscola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frameInserirEscola = new InserirEscola();
				frameInserirEscola.setVisible(true);
				frameInserirEscola.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent ev) {
						EscolaFrame.this.updateTable();
					}
				});
			}
		});
		
		JLabel lblEscolas = new JLabel("Escolas");
		
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
							Escola e = escolas.get(i);
							e.setNome(table.getValueAt(i, 1).toString());
							new EscolaController().update(e);
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
							Escola escola = escolas.get(i);
							escola.setNome(table.getValueAt(i, 1).toString());
							new EscolaController().delete(escola);
							JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
						}
					}
					updateTable();
				}
				
			}
		});
		
		JButton btnTurmas = new JButton("Turmas");
		btnTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListSelectionModel selecao = table.getSelectionModel();
				// se a seleção de linha tiver pelo menos uma linha
				if (!selecao.isSelectionEmpty()) {
					int minIndex = selecao.getMinSelectionIndex();
					int maxIndex = selecao.getMaxSelectionIndex();
					
					for (int i = minIndex; i <= maxIndex; i++) {
						if (selecao.isSelectedIndex(i)) {
							Escola escola = escolas.get(i);
							TurmaFrame frameTurmas = new TurmaFrame(escola.getIdEscola());
							frameTurmas.setVisible(true);
						}
					}
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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"ID", "Escola"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
		
		updateTable();
	}
	
	public Object[][] getEscolas()
	{
		int size = escolas.size();
		Object[][] tabela = new Object[size][2];
		
		for (int i = 0; i < size; i++) {
			Escola e = escolas.get(i);
			tabela[i][0] = e.getIdEscola();
			tabela[i][1] = e.getNome();
		}
		return tabela;
	}
	
	public void updateTable(){
        DefaultTableModel tTabela = (DefaultTableModel) table.getModel();
        tTabela.setNumRows(0);

        List<Escola> escolas = new EscolaController().readAll();
        int tam = escolas.size();

        for (int i = 0; i < tam; i++)
        {
            Escola escola = escolas.get(i);

            tTabela.addRow(new Object[]{1});

            table.setValueAt(escola.getIdEscola(), i, 0);
            table.setValueAt(escola.getNome(), i, 1);

        }

    }
}
