package com.aca.coffeestore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aca.coffeestore.model.Coffee;
import com.aca.coffeestore.model.FlavorWheel;
import com.aca.coffeestore.model.Process;
import com.aca.coffeestore.dao.MariaDbUtil;

public class CoffeeDaoImpl implements CoffeeDao{

	
	private static String selectAllCoffees = 
			"SELECT id, coffeeName, origin, processing, elevation, price, flavor " +
			"FROM coffees";
	
	private static String selectCoffeesById = 
			"SELECT id, coffeeName, origin, processing, elevation, price, flavor " + 
			"FROM coffees " + 
			"WHERE id = ? ";
	
	private static String selectCoffeesByProcess = 
			"SELECT id, coffeeName, origin, processing, elevation, price, flavor " +
			"FROM coffees " + 
			"WHERE processing = ? ";
	
	private static String selectCoffeesByFlavorWheel = 
			"SELECT id, coffeeName, origin, processing, elevation, price, flavor " +
			"FROM coffees " +
			"WHERE flavor = ? ";
	
	private static String selectCoffeesByOrigin = 
			"SELECT id, coffeeName, origin, processing, elevation, price, flavor " +
			"FROM coffees " +
			"WHERE origin = ? ";
	
	private static String deleteCoffeeById =
			"DELETE from coffees " + 
			"WHERE id = ? ";
	
	private static String updateCoffeesById = 
			" UPDATE coffees " +
			" SET coffeeName = ?, " +
			" 	origin = ?, " + 
			" 	processing = ?, " + 
			" 	elevation = ?, " + 
			" 	price = ?, " + 
			" 	flavor = ? " + 
			"WHERE id = ? ";
	
	private static String insertCoffee = 
			"INSERT INTO coffees (coffeeName, origin, processing, elevation, price, flavor) " + 
			"VALUES " +
			"(?, ?, ?, ?, ?, ?) ";
	
	private static String selectNewCoffeeId =
			"SELECT LAST_INSERT_ID() AS coffeeId ";
	
	@Override
	public List<Coffee> getProducts() {
		List<Coffee> myCoffee = new ArrayList<Coffee>();
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(selectAllCoffees);
			myCoffee = makeCoffee(result);
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return myCoffee;
	}

	private List<Coffee> makeCoffee(ResultSet result) throws SQLException {
		List<Coffee> myCoffees = new ArrayList<Coffee>();
		while(result.next()) {
			Coffee coffee = new Coffee();
			coffee.setName(result.getString("coffeeName"));
			coffee.setProductId(result.getInt("id"));
			coffee.setOrigin(result.getString("origin"));
			String processString = result.getString("processing");
			coffee.setProcess(Process.convertStringToProcess(processString));
			coffee.setElevation(result.getInt("elevation"));
			String flavorString = result.getString("flavor");
			coffee.setFlavor(FlavorWheel.convertStringToFlavorWheel(flavorString));
			coffee.setPrice(result.getInt("price"));
	
			
			myCoffees.add(coffee);
		}		
		return myCoffees;
	}

	@Override
	public List<Coffee> getCoffeesById(int id) {
		List<Coffee> myCoffees = new ArrayList<Coffee>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectCoffeesById);
			ps.setInt(1, id);
			result = ps.executeQuery();
			myCoffees = makeCoffee(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return myCoffees;
	}
	
	@Override
	public List<Coffee> getCoffeesByProcess(Process process) {
		List<Coffee> myCoffees = new ArrayList<Coffee>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectCoffeesByProcess);
			ps.setString(1, process.toString());
			result = ps.executeQuery();
			myCoffees = makeCoffee(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return myCoffees;
	}

	@Override
	public List<Coffee> getProductsByFlavorWheel(FlavorWheel flavorWheel) {
		List<Coffee> myCoffees = new ArrayList<Coffee>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectCoffeesByFlavorWheel);
			ps.setString(1, flavorWheel.toString());
			result = ps.executeQuery();
			myCoffees = makeCoffee(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return myCoffees;
	}
	
	@Override
	public List<Coffee> getCoffeesByOrigin(String origin) {
		List<Coffee> myCoffees = new ArrayList<Coffee>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectCoffeesByOrigin);
			ps.setString(1, origin);
			result = ps.executeQuery();
			myCoffees = makeCoffee(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return myCoffees;
	}
	
	@Override
	public Coffee deleteCoffeeById(int id) {
		List<Coffee> coffees = getCoffeesById(id);
		Coffee coffeeToDelete = null;
		
		if (coffees.size() > 0) {
			coffeeToDelete = coffees.get(0);
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MariaDbUtil.getConnection();
			
			try {
				ps = conn.prepareStatement(deleteCoffeeById);
				ps.setInt(1, id);
				updateRowCount = ps.executeUpdate();
				System.out.println("rows deleted: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		return coffeeToDelete;
	} 
	
	@Override
	public Coffee updateCoffee(Coffee updateCoffee) {
		List<Coffee> coffees = getCoffeesById(updateCoffee.getId());
		
		if (coffees.size() > 0) {

			int updateRowCount = 0;
			PreparedStatement ps = null;

			Connection conn = MariaDbUtil.getConnection();

			try {
				ps = conn.prepareStatement(updateCoffeesById);
				ps.setString(1, updateCoffee.getName());
				ps.setString(2, updateCoffee.getOrigin());
				ps.setString(3, updateCoffee.getProcess().toString());
				ps.setInt(4, updateCoffee.getElevation());
				ps.setInt(5, (int) updateCoffee.getPrice());
				ps.setString(6, updateCoffee.getFlavor().toString());
				ps.setInt(7, updateCoffee.getId());
				updateRowCount = ps.executeUpdate();
				System.out.println("rows inserted: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updateCoffee;
	}

	@Override
	public Coffee createCoffee(Coffee coffee) {		
		int updateRowCount = 0;
		PreparedStatement ps = null;

		Connection conn = MariaDbUtil.getConnection();

		try {
			ps = conn.prepareStatement(insertCoffee);
			ps.setString(1, coffee.getName());
			ps.setString(2, coffee.getOrigin());
			ps.setString(3, coffee.getProcess().toString());
			ps.setInt(4, coffee.getElevation());
			ps.setInt(5, (int) coffee.getPrice());
			ps.setString(6, coffee.getFlavor().toString());
			updateRowCount = ps.executeUpdate();
			System.out.println("rows inserted: " + updateRowCount);
			int productId = this.getNewCoffeeById(conn); 
			coffee.setProductId(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return coffee;
	}
	
	private int getNewCoffeeById (Connection conn) {
		ResultSet rs = null;
		Statement statement = null;
		int newCoffeeId = 0;
		
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(selectNewCoffeeId);
			while(rs.next()) {
				newCoffeeId = rs.getInt("coffeeId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return newCoffeeId;
	}

	@Override
	public List<Coffee> getCoffeesByQuizSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
