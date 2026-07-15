package model;

import model.Personagem;
import model.SQL;
import utils.Colunas;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class Acesso {
    public void inserir(Personagem personagem) throws SQLException {
        Connection conexao = SQL.conectar();
        if (conexao!=null) {
            String script = "insert into personagens(jogador, nome, tema, origem, idade, fisico, destreza, intelecto, consciencia, presenca) values (?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement pst = conexao.prepareStatement(script)) {
                pst.setString(1, personagem.getJogador());
                pst.setString(2, personagem.getNome());
                pst.setString(3, personagem.getTema());
                pst.setString(4, personagem.getOrigem());
                
                pst.setInt(5, personagem.getIdade());
                pst.setInt(6, personagem.getFisico());
                pst.setInt(7, personagem.getDestreza());
                pst.setInt(8, personagem.getIntelecto());
                pst.setInt(9, personagem.getConsciencia());
                pst.setInt(10, personagem.getPresenca());
                
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Erro ao adicionar personagem à tabela. Código de erro: "+e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão. Código de erro: "+e.getMessage());
                }
            }
        }
    }
    
    public void atualizar(String personagem, String coluna, String novoValor) throws SQLException {
        Connection conexao = SQL.conectar();
        if (!Colunas.contains(coluna)) {
            System.out.println("Campo declarado inválido.");
            return;
        }
        if (conexao!=null) {
            String script = "update personagens set "+coluna+" = ? where nome = ?";
            try (PreparedStatement pst = conexao.prepareStatement(script)) {
                pst.setString(1, novoValor);
                pst.setString(2, personagem);
                
                pst.executeUpdate();
                System.out.println("Personagem atualizado com sucesso.");
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar tabela. Código de erro: "+e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão. Código de erro: "+e.getMessage());
                }
            }
        }
    }
    
    public void atualizar(String personagem, String coluna, int novoValor) throws SQLException {
        Connection conexao = SQL.conectar();
        if (!Colunas.contains(coluna)) {
            System.out.println("Campo declarado inválido.");
            return;
        }
        if (conexao!=null) {
            String script = "update personagens set "+coluna+" = ? where nome = ?";
            try (PreparedStatement pst = conexao.prepareStatement(script)) {
                pst.setInt(1, novoValor);
                pst.setString(2, personagem);
                
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar tabela. Código de erro: "+e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão. Código de erro: "+e.getMessage());
                }
            }
        }
    }
    
    public void deletar(String personagem, String jogador) throws SQLException {
        Connection conexao = SQL.conectar();
        if (conexao!=null) {
            String script = "delete from personagens where nome = ? and jogador = ?";
            try (PreparedStatement pst = conexao.prepareStatement(script)) {
                pst.setString(1, personagem);
                pst.setString(2, jogador);
                
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Erro ao deletar personagem. Código de erro: "+e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão. Código de erro: "+e.getMessage());
                }
            }
        }
    }
    
    public List<Personagem> listarTodos() throws SQLException {
        Connection conexao = SQL.conectar();
        Personagem personagem = new Personagem();
        ArrayList<Personagem> personagens = new ArrayList<>();
            
        if (conexao!=null) {
            
            String script = "select * from personagens";
            try (PreparedStatement pst = conexao.prepareStatement(script)) {
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()) {
                    personagem.setId(rs.getInt("id"));
                    personagem.setJogador(rs.getString("jogador"));
                    personagem.setNome(rs.getString("nome"));
                    personagem.setTema(rs.getString("tema"));
                    personagem.setOrigem(rs.getString("origem"));
                    personagem.setIdade(rs.getInt("idade"));
                    personagem.setFisico(rs.getInt("fisico"));
                    personagem.setDestreza(rs.getInt("destreza"));
                    personagem.setIntelecto(rs.getInt("intelecto"));
                    personagem.setConsciencia(rs.getInt("consciencia"));
                    personagem.setPresenca(rs.getInt("presenca"));
                    personagens.add(personagem);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao selecionar personagens. Código de erro: "+e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão. Código de erro: "+e.getMessage());
                }
            }
        }
        return personagens;
    }
    
    public List<Personagem> listarCom(String coluna, String alvo) throws SQLException {
        Connection conexao = SQL.conectar();
        Personagem personagem = new Personagem();
        ArrayList<Personagem> personagens = new ArrayList<>();
        
        if (!Colunas.contains(coluna)) {
            System.out.println("Coluna alvo inválida");
            return personagens;
        }
        
        if (conexao!=null) {
            
            String script = "select * from personagens where "+coluna+" = ?";
            try (PreparedStatement pst = conexao.prepareStatement(script)) {
                pst.setString(1, alvo);
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()) {
                    personagem.setId(rs.getInt("id"));
                    personagem.setJogador(rs.getString("jogador"));
                    personagem.setNome(rs.getString("nome"));
                    personagem.setTema(rs.getString("tema"));
                    personagem.setOrigem(rs.getString("origem"));
                    personagem.setIdade(rs.getInt("idade"));
                    personagem.setFisico(rs.getInt("fisico"));
                    personagem.setDestreza(rs.getInt("destreza"));
                    personagem.setIntelecto(rs.getInt("intelecto"));
                    personagem.setConsciencia(rs.getInt("consciencia"));
                    personagem.setPresenca(rs.getInt("presenca"));
                    personagens.add(personagem);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao selecionar personagens. Código de erro: "+e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão. Código de erro: "+e.getMessage());
                }
            }
        }
        return personagens;
    }
    
    public List<Personagem> listarCom(String coluna, int alvo) throws SQLException {
        Connection conexao = SQL.conectar();
        Personagem personagem = new Personagem();
        ArrayList<Personagem> personagens = new ArrayList<>();
        
        if (!Colunas.contains(coluna)) {
            System.out.println("Coluna alvo inválida");
            return personagens;
        }
        
        if (conexao!=null) {
            
            String script = "select * from personagens where "+coluna+" = ?";
            try (PreparedStatement pst = conexao.prepareStatement(script)) {
                pst.setInt(1, alvo);
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()) {
                    personagem.setId(rs.getInt("id"));
                    personagem.setJogador(rs.getString("jogador"));
                    personagem.setNome(rs.getString("nome"));
                    personagem.setTema(rs.getString("tema"));
                    personagem.setOrigem(rs.getString("origem"));
                    personagem.setIdade(rs.getInt("idade"));
                    personagem.setFisico(rs.getInt("fisico"));
                    personagem.setDestreza(rs.getInt("destreza"));
                    personagem.setIntelecto(rs.getInt("intelecto"));
                    personagem.setConsciencia(rs.getInt("consciencia"));
                    personagem.setPresenca(rs.getInt("presenca"));
                    personagens.add(personagem);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao selecionar personagens. Código de erro: "+e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão. Código de erro: "+e.getMessage());
                }
            }
        }
        return personagens;
    }
}
