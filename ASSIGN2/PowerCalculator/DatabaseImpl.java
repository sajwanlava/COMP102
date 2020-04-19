 

import java.util.ArrayList;

public class DatabaseImpl implements Database {
	private ColumnType[] schema;
	private int key;

	ArrayList<Object[]> rows;

	public DatabaseImpl(int key, ColumnType[] schemaLine,ArrayList<Object[]> r) {
		rows = r;
		schema = schemaLine;
		this.key=key;
	}

	/**
	 * Get the schema for this database. This returns the name and type for each
	 * column in the database. All rows in the database must confirm to this
	 * schema.
	 *
	 * @return
	 */
	@Override
	public ColumnType[] getSchema() {
		return schema;
	}

	@Override
	public int getKeyField() {
		return key;
	}

	@Override
	public int size() {
		//is number of columns
		return rows.size();
	}

	@Override
	public void addRow(Object... data) throws InvalidRowException, DuplicateKeyException {
		//if(rows.size()!=schema.length)
		if(data.length!=schema.length)
			throw new InvalidRowException();

		for(int i=0;i<schema.length;i++) {
			if(!schema[i].getType().isInstance(data[i]))
				throw new InvalidRowException();
		}

		for(Object[] row:rows) {
			if(row[key].equals(data[key]))
				throw new DuplicateKeyException();
		}
		rows.add(data);
	}

	@Override
	public Object[] getRow(Object key) throws InvalidKeyException {
		for(Object[] row: rows) {
			if(row[this.key].equals(key)) {
				return row;
			}
		}
		throw new InvalidKeyException();
	}

	/**
	 * Get a row from the database based on its index value, rather than its key
	 * field. The index cannot be negative and must be less than the number of
	 * rows, otherwise an IndexOutOfBoundsException is thrown.
	 *
	 * @param index
	 * @return the index-th row of the ordered data, where the first row is row
	 *         0
	 * @throws IndexOutOfBoundsException
	 *             if a row at the given index does not exist
	 */
	@Override
	public Object[] getRow(int index) throws IndexOutOfBoundsException {
		return rows.get(index);
	}

}
