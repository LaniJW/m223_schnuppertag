package ch.nyp.schnuppertag_software.data;

import ch.nyp.schnuppertag_software.webcontext.address.Address;

public class AddressDataGenerator implements DataGenerator<Address>
{
	@Override
	public DataHolder<Address> generate(){
		return DataHolder.of(
				new Address(0L, "Daniel Radcliffe", "Terra Cottage", "1", "8434", "On The Cliffs", "Great Britain"),
				new Address(0L, "Rupert Grint", "Fuchsbau", "1", "12383", "In The Fields", "Great Britain"),
				new Address(0L, "Emma Watson", "Down Str.", "1", "92342", "Merrytown", "Great Britain")
				);
	}
}
