package app.dao;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import app.db.ConnectDB;
import app.entity.Customer;
import app.entity.Phone;

public class CustomerDAO {
	private MongoCollection<Customer> cusCol;

	public CustomerDAO() {
		PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();

		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(pojoCodecProvider));

		this.cusCol = ConnectDB.getInstance().getMongoClient().getDatabase("BikeStores")
				.getCollection("customers", Customer.class).withCodecRegistry(codecRegistry);
	}

	public boolean addCustomer(Customer customer) {
		InsertOneResult result = cusCol.insertOne(customer);
		if (result.getInsertedId() != null)
			return true;
		return false;
	}

	public boolean addNewPhone2Customer(String customerId, Phone newPhone) {
		Bson filter = Filters.eq("_id", customerId);

		Customer customer = cusCol.find(filter).first();

		// check customer
		if (customer != null) {
			// check phone
			if (!customer.getPhones().contains(newPhone)) {
				customer.getPhones().add(newPhone);

				Document data = new Document().append("phones", customer.getPhones());
				Document update = new Document().append("$set", data);
				UpdateResult result = cusCol.updateOne(filter, update);

				if (result.getModifiedCount() > 0) {
					// System.out.println(result.getModifiedCount());
					return true;
				}
			} else {
				System.out.println("Số điện thoại trùng");
			}
		} else {
			System.out.println("Khách hàng không tồn tại!");

		}
		return false;

	}

}
