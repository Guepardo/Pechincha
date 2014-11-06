package module1.pechincha.cruds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import module1.pechincha.interf.DAOBehavior;
import module1.pechincha.model.Produto;
import module1.pechincha.util.ConnectionFactory;

public class JDBCProdutoDAO extends DAOBehavior<Produto>{
	private Connection c; 
	
	public JDBCProdutoDAO(){
		c = ConnectionFactory.getConnection();
	};
	
	@Override
	public void insert(Produto arg) {
		String sql = "Insert into "+arg.getTableName()+" ("+arg.getColumnName()+") values ( ?, ?, ?, ?, ? )"; 
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,arg.getTitulo());
			ps.setString(2,arg.getDescricao());
			ps.setFloat(3, arg.getPreco());
			ps.setInt(4, arg.getQuantidade());
			ps.setInt(5, arg.getFkUsuario());
			ps.execute(); 
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir dados. Classe JDBCProdutoDAO", e); 
		}
	};

	@Override
	public void delete(int pk) {
		try {
			PreparedStatement ps = c.prepareStatement("delete from produto where pk = ?");
			ps.setInt(1,pk);
			ps.execute();
			ps.close();
		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao deletar dados. Classe JDBCProdutoDAO", e); 
		}
	};

	public List<Produto> list(int fkusuario) {
		List<Produto> list = new ArrayList<Produto>();
		
		try {
			PreparedStatement ps = c.prepareStatement("select * from produto where fkusuario = ?");
			ps.setInt(1,fkusuario);
			ResultSet result = ps.executeQuery();
			while(result.next()){
				Produto temp = new Produto();
				ps.setString(1,result.getString("titulo"));
				ps.setString(2,result.getString("descricao"));
				ps.setFloat(3, result.getFloat("preco"));
				ps.setInt(4, result.getInt("quantidade"));
				ps.setInt(5, result.getInt("fkusuario"));
				list.add(temp);
			}
			result.close();
			ps.close();
		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar dados. Classe JDBCLanceDAO", e); 
		}
		return list;
	};
	
	@Override
	public List<Produto> list() {
		List<Produto> list = new ArrayList<Produto>();
		
		try {
			PreparedStatement ps = c.prepareStatement("select * from produto");
			ResultSet result = ps.executeQuery();
			while(result.next()){
				Produto temp = new Produto();
				ps.setString(1,result.getString("titulo"));
				ps.setString(2,result.getString("descricao"));
				ps.setFloat(3, result.getFloat("preco"));
				ps.setInt(4, result.getInt("quantidade"));
				ps.setInt(5, result.getInt("fkusuario"));
				list.add(temp);
			}
			result.close();
			ps.close();
		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar dados. Classe JDBCLanceDAO", e); 
		}
		return list;
	};

	@Override
	public Produto search(int pk) {
		Produto temp = null;
		try {
			PreparedStatement ps = c.prepareStatement("select * from lance where idleilao = ? and lance = (select max(lance) from lance where idleilao = ?");
			ps.setInt(1,pk);
			ResultSet result = ps.executeQuery();
			temp = new Produto(); 
			while(result.next()){
				temp.setTitulo(result.getString("titulo"));
				temp.setDescricao(result.getString("descricao"));
				temp.setPreco(result.getFloat("preco"));
				temp.setQuantidade(result.getInt("quantidade"));
				temp.setFkUsuario(result.getInt("fkusuario"));
			}
			result.close();
			ps.close();
		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao procurar dados. Classe JDBCLanceDAO", e); 
		}
		return temp;
	};

	@Override
	public void update(Produto arg) {
		
	};
}