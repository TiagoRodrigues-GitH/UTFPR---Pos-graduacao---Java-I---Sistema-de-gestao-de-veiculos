
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atividade_09;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tiago Rodrigues
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Teste {

    private static ArrayList<Passeio> listaPasseio = new ArrayList<>();
    private static ArrayList<Carga> listaCarga = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Teste::createMainWindow);
    }

    private static void createMainWindow() {
        JFrame frame = new JFrame("Gestão de Veículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Gestão de Veículos", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        frame.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton btnPasseio = new JButton("Passeio");
        JButton btnCarga = new JButton("Carga");

        buttonPanel.add(btnPasseio);
        buttonPanel.add(btnCarga);

        JPanel centerWrapper = new JPanel();
        centerWrapper.setLayout(new GridBagLayout());
        centerWrapper.add(buttonPanel);

        frame.add(centerWrapper, BorderLayout.CENTER);

        btnPasseio.addActionListener(e -> createPasseioWindow(frame));
        btnCarga.addActionListener(e -> createCargaWindow(frame));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createPasseioWindow(JFrame mainFrame) {
        JFrame frame = new JFrame("Veículos de Passeio");
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnConsultar = new JButton("Consultar/Excluir pela placa");
        JButton btnImprimir = new JButton("Imprimir/Excluir todos");
        JButton btnSair = new JButton("Sair");

        frame.add(btnCadastrar);
        frame.add(btnConsultar);
        frame.add(btnImprimir);
        frame.add(btnSair);

        btnCadastrar.addActionListener(e -> cadPasseioGUI());
        btnConsultar.addActionListener(e -> consultarExcluirPasseioGUI());
        btnImprimir.addActionListener(e -> imprimirExcluirTodosPasseioGUI());

        btnSair.addActionListener(e -> frame.dispose());

        frame.setLocationRelativeTo(mainFrame);
        frame.setVisible(true);
    }

    private static void createCargaWindow(JFrame mainFrame) {
        JFrame frame = new JFrame("Veículos de Carga");
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnConsultar = new JButton("Consultar/Excluir pela placa");
        JButton btnImprimir = new JButton("Imprimir/Excluir todos");
        JButton btnSair = new JButton("Sair");

        frame.add(btnCadastrar);
        frame.add(btnConsultar);
        frame.add(btnImprimir);
        frame.add(btnSair);

        btnCadastrar.addActionListener(e -> cadCargaGUI());
        btnConsultar.addActionListener(e -> consultarExcluirCargaGUI());
        btnImprimir.addActionListener(e -> imprimirExcluirTodosCargaGUI());

        btnSair.addActionListener(e -> frame.dispose());

        frame.setLocationRelativeTo(mainFrame);
        frame.setVisible(true);
    }

    private static void cadPasseioGUI() {
        
     JFrame frame = new JFrame("Cadastro de Passeio");
    frame.setSize(400, 400);
    frame.setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel(new GridLayout(9, 2));
    JTextField tfQtdPass = new JTextField();
    JTextField tfPlaca = new JTextField();
    JTextField tfMarca = new JTextField();
    JTextField tfModelo = new JTextField();
    JTextField tfCor = new JTextField();
    JTextField tfQtdRodas = new JTextField();
    JTextField tfVelocMax = new JTextField();
    JTextField tfQtdPist = new JTextField();
    JTextField tfPotencia = new JTextField();

    inputPanel.add(new JLabel("Qtd Passageiros:"));
    inputPanel.add(tfQtdPass);
    inputPanel.add(new JLabel("Placa:"));
    inputPanel.add(tfPlaca);
    inputPanel.add(new JLabel("Marca:"));
    inputPanel.add(tfMarca);
    inputPanel.add(new JLabel("Modelo:"));
    inputPanel.add(tfModelo);
    inputPanel.add(new JLabel("Cor:"));
    inputPanel.add(tfCor);
    inputPanel.add(new JLabel("Qtd Rodas:"));
    inputPanel.add(tfQtdRodas);
    inputPanel.add(new JLabel("Veloc Max:"));
    inputPanel.add(tfVelocMax);
    inputPanel.add(new JLabel("Qtd Pistoes:"));
    inputPanel.add(tfQtdPist);
    inputPanel.add(new JLabel("Potencia:"));
    inputPanel.add(tfPotencia);

    JPanel buttonPanel = new JPanel(new FlowLayout());
    JButton btnCadastrar = new JButton("Cadastrar");
    JButton btnLimpar = new JButton("Limpar");
    JButton btnNovo = new JButton("Novo");
    JButton btnSair = new JButton("Sair");

    buttonPanel.add(btnCadastrar);
    buttonPanel.add(btnLimpar);
    buttonPanel.add(btnNovo);
    buttonPanel.add(btnSair);

    frame.add(inputPanel, BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);

    btnSair.addActionListener(e -> frame.dispose());

    btnCadastrar.addActionListener(e -> {
        try {
            String placa = tfPlaca.getText();
            for (Carga c : listaCarga) {
                if (c.getPlaca().equalsIgnoreCase(placa)) {
                    throw new VeicExistException();
                }
            }
            for (Passeio p : listaPasseio) {
                if (p.getPlaca().equalsIgnoreCase(placa)) {
                    throw new VeicExistException();
                }
            }

            Passeio passeio = new Passeio();
            passeio.setQtdPassageiros(Integer.parseInt(tfQtdPass.getText()));
            passeio.setPlaca(placa);
            passeio.setMarca(tfMarca.getText());
            passeio.setModelo(tfModelo.getText());
            passeio.setCor(tfCor.getText());
            passeio.setQtdRodas(Integer.parseInt(tfQtdRodas.getText()));

            float vMax = Float.parseFloat(tfVelocMax.getText());
            if (vMax < 80 || vMax > 110) {
                passeio.setVelocMax(100f); 
                JOptionPane.showMessageDialog(frame, "A velocidade máxima está fora dos limites. Ajustada para 100 km/h.");
            } else {
                passeio.setVelocMax(vMax);
            }

            passeio.getMotor().setQtdPist(Integer.parseInt(tfQtdPist.getText()));
            passeio.getMotor().setPotencia(Integer.parseInt(tfPotencia.getText()));

            listaPasseio.add(passeio);
            JOptionPane.showMessageDialog(frame, "Veículo de passeio cadastrado com sucesso!");

            clearFieldsPasseio(tfQtdPass, tfPlaca, tfMarca, tfModelo, tfCor, tfQtdRodas, tfVelocMax, tfQtdPist, tfPotencia);

        } catch (VeicExistException ex) {
            JOptionPane.showMessageDialog(frame, "Já existe um veículo com esta placa. Por favor, insira uma placa diferente.");
            tfPlaca.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Erro ao cadastrar: " + ex.getMessage());
        }
    });

    btnLimpar.addActionListener(e -> {
        clearFieldsPasseio(tfQtdPass, tfPlaca, tfMarca, tfModelo, tfCor, tfQtdRodas, tfVelocMax, tfQtdPist, tfPotencia);
    });

    btnNovo.addActionListener(e -> {
        clearFieldsPasseio(tfQtdPass, tfPlaca, tfMarca, tfModelo, tfCor, tfQtdRodas, tfVelocMax, tfQtdPist, tfPotencia);
    });

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);    
        
        
        
}

private static void clearFieldsPasseio(JTextField... fields) {
    for (JTextField field : fields) {
        field.setText("");
    }
    }

 private static void cadCargaGUI() {
        JFrame frame = new JFrame("Cadastro de Carga");
    frame.setSize(400, 400);
    frame.setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel(new GridLayout(10, 2));
    JTextField tfTara = new JTextField();
    JTextField tfCargaMax = new JTextField();
    JTextField tfPlaca = new JTextField();
    JTextField tfMarca = new JTextField();
    JTextField tfModelo = new JTextField();
    JTextField tfCor = new JTextField();
    JTextField tfQtdRodas = new JTextField();
    JTextField tfVelocMax = new JTextField();
    JTextField tfQtdPist = new JTextField();
    JTextField tfPotencia = new JTextField();

    inputPanel.add(new JLabel("Tara:"));
    inputPanel.add(tfTara);
    inputPanel.add(new JLabel("Carga Max:"));
    inputPanel.add(tfCargaMax);
    inputPanel.add(new JLabel("Placa:"));
    inputPanel.add(tfPlaca);
    inputPanel.add(new JLabel("Marca:"));
    inputPanel.add(tfMarca);
    inputPanel.add(new JLabel("Modelo:"));
    inputPanel.add(tfModelo);
    inputPanel.add(new JLabel("Cor:"));
    inputPanel.add(tfCor);
    inputPanel.add(new JLabel("Qtd Rodas:"));
    inputPanel.add(tfQtdRodas);
    inputPanel.add(new JLabel("Veloc Max:"));
    inputPanel.add(tfVelocMax);
    inputPanel.add(new JLabel("Qtd Pistoes:"));
    inputPanel.add(tfQtdPist);
    inputPanel.add(new JLabel("Potencia:"));
    inputPanel.add(tfPotencia);

    JPanel buttonPanel = new JPanel(new FlowLayout());
    JButton btnCadastrar = new JButton("Cadastrar");
    JButton btnLimpar = new JButton("Limpar");
    JButton btnNovo = new JButton("Novo");
    JButton btnSair = new JButton("Sair");

    buttonPanel.add(btnCadastrar);
    buttonPanel.add(btnLimpar);
    buttonPanel.add(btnNovo);
    buttonPanel.add(btnSair);

    frame.add(inputPanel, BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);

    btnSair.addActionListener(e -> frame.dispose());

    btnCadastrar.addActionListener(e -> {
        try {
            String placa = tfPlaca.getText();
            for (Passeio p : listaPasseio) {
                if (p.getPlaca().equalsIgnoreCase(placa)) {
                    throw new VeicExistException();
                }
            }
            for (Carga c : listaCarga) {
                if (c.getPlaca().equalsIgnoreCase(placa)) {
                    throw new VeicExistException();
                }
            }

            Carga carga = new Carga();
            carga.setTara(Integer.parseInt(tfTara.getText()));
            carga.setCargaMax(Integer.parseInt(tfCargaMax.getText()));
            carga.setPlaca(placa);
            carga.setMarca(tfMarca.getText());
            carga.setModelo(tfModelo.getText());
            carga.setCor(tfCor.getText());
            carga.setQtdRodas(Integer.parseInt(tfQtdRodas.getText()));

            float vMax = Float.parseFloat(tfVelocMax.getText());
            if (vMax < 80 || vMax > 110) {
                carga.setVelocMax(90f); 
                JOptionPane.showMessageDialog(frame, "A velocidade máxima está fora dos limites. Ajustada para 90 km/h.");
            } else {
                carga.setVelocMax(vMax);
            }

            carga.getMotor().setQtdPist(Integer.parseInt(tfQtdPist.getText()));
            carga.getMotor().setPotencia(Integer.parseInt(tfPotencia.getText()));

            listaCarga.add(carga);
            JOptionPane.showMessageDialog(frame, "Veículo de carga cadastrado com sucesso!");

            clearFieldsCarga(tfTara, tfCargaMax, tfPlaca, tfMarca, tfModelo, tfCor, tfQtdRodas, tfVelocMax, tfQtdPist, tfPotencia);

        } catch (VeicExistException ex) {
            JOptionPane.showMessageDialog(frame, "Já existe um veículo com esta placa. Por favor, insira uma placa diferente.");
            tfPlaca.setText(""); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Erro ao cadastrar: " + ex.getMessage());
        }
    });

    btnLimpar.addActionListener(e -> {
        clearFieldsCarga(tfTara, tfCargaMax, tfPlaca, tfMarca, tfModelo, tfCor, tfQtdRodas, tfVelocMax, tfQtdPist, tfPotencia);
    });

    btnNovo.addActionListener(e -> {
        clearFieldsCarga(tfTara, tfCargaMax, tfPlaca, tfMarca, tfModelo, tfCor, tfQtdRodas, tfVelocMax, tfQtdPist, tfPotencia);
    });

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
     
     
}

private static void clearFieldsCarga(JTextField... fields) {
    for (JTextField field : fields) {
        field.setText("");
    }
}
    private static void consultarExcluirPasseioGUI() {
        JFrame frame = new JFrame("Consultar/Excluir pela placa");
        frame.setSize(400, 450);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        JTextField tfBuscaPlaca = new JTextField();

        JTextField tfQtdPass = new JTextField();
        tfQtdPass.setEditable(false);
        JTextField tfPlaca = new JTextField();
        tfPlaca.setEditable(false);
        JTextField tfMarca = new JTextField();
        tfMarca.setEditable(false);
        JTextField tfModelo = new JTextField();
        tfModelo.setEditable(false);
        JTextField tfCor = new JTextField();
        tfCor.setEditable(false);
        JTextField tfQtdRodas = new JTextField();
        tfQtdRodas.setEditable(false);
        JTextField tfVelocMax = new JTextField();
        tfVelocMax.setEditable(false);
        JTextField tfQtdPist = new JTextField();
        tfQtdPist.setEditable(false);
        JTextField tfPotencia = new JTextField();
        tfPotencia.setEditable(false);

        inputPanel.add(new JLabel("Informe a Placa:"));
        inputPanel.add(tfBuscaPlaca);
        inputPanel.add(new JLabel("Qtd Passageiros:"));
        inputPanel.add(tfQtdPass);
        inputPanel.add(new JLabel("Placa:"));
        inputPanel.add(tfPlaca);
        inputPanel.add(new JLabel("Marca:"));
        inputPanel.add(tfMarca);
        inputPanel.add(new JLabel("Modelo:"));
        inputPanel.add(tfModelo);
        inputPanel.add(new JLabel("Cor:"));
        inputPanel.add(tfCor);
        inputPanel.add(new JLabel("Qtd Rodas:"));
        inputPanel.add(tfQtdRodas);
        inputPanel.add(new JLabel("Veloc Max:"));
        inputPanel.add(tfVelocMax);
        inputPanel.add(new JLabel("Qtd Pistoes:"));
        inputPanel.add(tfQtdPist);
        inputPanel.add(new JLabel("Potencia:"));
        inputPanel.add(tfPotencia);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnConsultar = new JButton("Consultar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnConsultar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnSair);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        btnConsultar.addActionListener(e -> {
            String placaBusca = tfBuscaPlaca.getText().trim().toLowerCase();
            Passeio encontrado = null;
            for (Passeio p : listaPasseio) {
                if (p.getPlaca().toLowerCase().equals(placaBusca)) {
                    encontrado = p;
                    break;
                }
            }

            if (encontrado != null) {
                tfQtdPass.setText(String.valueOf(encontrado.getQtdPassageiros()));
                tfPlaca.setText(encontrado.getPlaca());
                tfMarca.setText(encontrado.getMarca());
                tfModelo.setText(encontrado.getModelo());
                tfCor.setText(encontrado.getCor());
                tfQtdRodas.setText(String.valueOf(encontrado.getQtdRodas()));
                tfVelocMax.setText(String.valueOf(encontrado.getVelocMax()));
                tfQtdPist.setText(String.valueOf(encontrado.getMotor().getQtdPist()));
                tfPotencia.setText(String.valueOf(encontrado.getMotor().getPotencia()));
            } else {
                JOptionPane.showMessageDialog(frame, "Veículo não encontrado!");
            }
        });

        btnExcluir.addActionListener(e -> {
            String placaBusca = tfBuscaPlaca.getText().trim().toLowerCase();
            Passeio encontrado = null;
            for (Passeio p : listaPasseio) {
                if (p.getPlaca().toLowerCase().equals(placaBusca)) {
                    encontrado = p;
                    break;
                }
            }

            if (encontrado != null) {
                listaPasseio.remove(encontrado);
                JOptionPane.showMessageDialog(frame, "Veículo excluído com sucesso!");

                // Limpa os campos
                tfQtdPass.setText("");
                tfPlaca.setText("");
                tfMarca.setText("");
                tfModelo.setText("");
                tfCor.setText("");
                tfQtdRodas.setText("");
                tfVelocMax.setText("");
                tfQtdPist.setText("");
                tfPotencia.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Veículo não encontrado para excluir.");
            }
        });

        btnSair.addActionListener(e -> frame.dispose());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void imprimirExcluirTodosPasseioGUI() {

        JFrame frame = new JFrame("Todos os Veículos de Passeio");
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        String[] colunas = {
            "Qtd Passageiros", "Placa", "Marca", "Modelo", "Cor",
            "Qtd Rodas", "Veloc Max", "Qtd Pistões", "Potência"
        };

        String[][] dados = new String[0][colunas.length];
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);

        JPanel buttonPanel = new JPanel();
        JButton btnImprimirTodos = new JButton("Imprimir Todos");
        JButton btnExcluirTodos = new JButton("Excluir Todos");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnImprimirTodos);
        buttonPanel.add(btnExcluirTodos);
        buttonPanel.add(btnSair);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        btnImprimirTodos.addActionListener(e -> {
            String[][] newDados = new String[listaPasseio.size()][colunas.length];
            for (int i = 0; i < listaPasseio.size(); i++) {
                Passeio p = listaPasseio.get(i);
                newDados[i][0] = String.valueOf(p.getQtdPassageiros());
                newDados[i][1] = p.getPlaca();
                newDados[i][2] = p.getMarca();
                newDados[i][3] = p.getModelo();
                newDados[i][4] = p.getCor();
                newDados[i][5] = String.valueOf(p.getQtdRodas());
                newDados[i][6] = String.valueOf(p.getVelocMax());
                newDados[i][7] = String.valueOf(p.getMotor().getQtdPist());
                newDados[i][8] = String.valueOf(p.getMotor().getPotencia());
            }
            tabela.setModel(new DefaultTableModel(newDados, colunas)); // Update the table model with new data
        });

        btnExcluirTodos.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja excluir todos os veículos?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                listaPasseio.clear();
                tabela.setModel(new DefaultTableModel(new String[0][colunas.length], colunas)); // Clear the table
            }
        });

        btnSair.addActionListener(e -> {
            frame.dispose();
           
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private static void consultarExcluirCargaGUI() {

        JFrame frame = new JFrame("Consultar/Excluir pela placa");
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(11, 2));
        JTextField tfBuscaPlaca = new JTextField();

        JTextField tfTara = new JTextField();
        tfTara.setEditable(false);
        JTextField tfCargaMax = new JTextField();
        tfCargaMax.setEditable(false);
        JTextField tfPlaca = new JTextField();
        tfPlaca.setEditable(false);
        JTextField tfMarca = new JTextField();
        tfMarca.setEditable(false);
        JTextField tfModelo = new JTextField();
        tfModelo.setEditable(false);
        JTextField tfCor = new JTextField();
        tfCor.setEditable(false);
        JTextField tfQtdRodas = new JTextField();
        tfQtdRodas.setEditable(false);
        JTextField tfVelocMax = new JTextField();
        tfVelocMax.setEditable(false);
        JTextField tfQtdPist = new JTextField();
        tfQtdPist.setEditable(false);
        JTextField tfPotencia = new JTextField();
        tfPotencia.setEditable(false);

        inputPanel.add(new JLabel("Informe a Placa:"));
        inputPanel.add(tfBuscaPlaca);
        inputPanel.add(new JLabel("Tara:"));
        inputPanel.add(tfTara);
        inputPanel.add(new JLabel("Carga Máx:"));
        inputPanel.add(tfCargaMax);
        inputPanel.add(new JLabel("Placa:"));
        inputPanel.add(tfPlaca);
        inputPanel.add(new JLabel("Marca:"));
        inputPanel.add(tfMarca);
        inputPanel.add(new JLabel("Modelo:"));
        inputPanel.add(tfModelo);
        inputPanel.add(new JLabel("Cor:"));
        inputPanel.add(tfCor);
        inputPanel.add(new JLabel("Qtd Rodas:"));
        inputPanel.add(tfQtdRodas);
        inputPanel.add(new JLabel("Veloc Max:"));
        inputPanel.add(tfVelocMax);
        inputPanel.add(new JLabel("Qtd Pistoes:"));
        inputPanel.add(tfQtdPist);
        inputPanel.add(new JLabel("Potência:"));
        inputPanel.add(tfPotencia);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnConsultar = new JButton("Consultar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnConsultar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnSair);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        btnConsultar.addActionListener(e -> {
            String placaBusca = tfBuscaPlaca.getText().trim().toLowerCase();
            Carga encontrado = null;
            for (Carga c : listaCarga) {
                if (c.getPlaca().toLowerCase().equals(placaBusca)) {
                    encontrado = c;
                    break;
                }
            }

            if (encontrado != null) {
                tfTara.setText(String.valueOf(encontrado.getTara()));
                tfCargaMax.setText(String.valueOf(encontrado.getCargaMax()));
                tfPlaca.setText(encontrado.getPlaca());
                tfMarca.setText(encontrado.getMarca());
                tfModelo.setText(encontrado.getModelo());
                tfCor.setText(encontrado.getCor());
                tfQtdRodas.setText(String.valueOf(encontrado.getQtdRodas()));
                tfVelocMax.setText(String.valueOf(encontrado.getVelocMax()));
                tfQtdPist.setText(String.valueOf(encontrado.getMotor().getQtdPist()));
                tfPotencia.setText(String.valueOf(encontrado.getMotor().getPotencia()));
            } else {
                JOptionPane.showMessageDialog(frame, "Veículo não encontrado!");
            }
        });

        btnExcluir.addActionListener(e -> {
            String placaBusca = tfBuscaPlaca.getText().trim().toLowerCase();
            Carga encontrado = null;
            for (Carga c : listaCarga) {
                if (c.getPlaca().toLowerCase().equals(placaBusca)) {
                    encontrado = c;
                    break;
                }
            }

            if (encontrado != null) {
                listaCarga.remove(encontrado);
                JOptionPane.showMessageDialog(frame, "Veículo excluído com sucesso!");

              
                tfTara.setText("");
                tfCargaMax.setText("");
                tfPlaca.setText("");
                tfMarca.setText("");
                tfModelo.setText("");
                tfCor.setText("");
                tfQtdRodas.setText("");
                tfVelocMax.setText("");
                tfQtdPist.setText("");
                tfPotencia.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Veículo não encontrado para excluir.");
            }
        });

        btnSair.addActionListener(e -> frame.dispose());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void imprimirExcluirTodosCargaGUI() {
        JFrame frame = new JFrame("Todos os Veículos de Carga");
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        String[] colunas = {
            "Tara", "Carga Max", "Placa", "Marca", "Modelo", "Cor",
            "Qtd Rodas", "Veloc Max", "Qtd Pistões", "Potência"
        };

        String[][] dados = new String[0][colunas.length]; // Start with an empty array
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);

        JPanel buttonPanel = new JPanel();
        JButton btnImprimirTodos = new JButton("Imprimir Todos");
        JButton btnExcluirTodos = new JButton("Excluir Todos");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnImprimirTodos);
        buttonPanel.add(btnExcluirTodos);
        buttonPanel.add(btnSair);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        btnImprimirTodos.addActionListener(e -> {
            String[][] newDados = new String[listaCarga.size()][colunas.length];
            for (int i = 0; i < listaCarga.size(); i++) {
                Carga c = listaCarga.get(i);
                newDados[i][0] = String.valueOf(c.getTara());
                newDados[i][1] = String.valueOf(c.getCargaMax());
                newDados[i][2] = c.getPlaca();
                newDados[i][3] = c.getMarca();
                newDados[i][4] = c.getModelo();
                newDados[i][5] = c.getCor();
                newDados[i][6] = String.valueOf(c.getQtdRodas());
                newDados[i][7] = String.valueOf(c.getVelocMax());
                newDados[i][8] = String.valueOf(c.getMotor().getQtdPist());
                newDados[i][9] = String.valueOf(c.getMotor().getPotencia());
            }
            tabela.setModel(new DefaultTableModel(newDados, colunas)); // Update the table model with new data
        });

        btnExcluirTodos.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja excluir todos os veículos?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                listaCarga.clear();
                tabela.setModel(new DefaultTableModel(new String[0][colunas.length], colunas)); // Clear the table
            }
        });

        btnSair.addActionListener(e -> {
            frame.dispose();
            
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
