package ch.nyp.schnuppertag_software.data;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.location.Location;
import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;
import ch.nyp.schnuppertag_software.webcontext.trainee.Trainee;
import ch.nyp.schnuppertag_software.webcontext.trainer.Trainer;
import ch.nyp.schnuppertag_software.webcontext.trialday.TrialDay;

public class DataGenerators
{
	public static <T> DataGenerator<T> forClass(Class<T> clazz){
		return new DataGenerators().build(clazz);
	}

	public <T> DataGenerator<T> build(Class<T> clazz){
		DataGenerator<?> gen;

		if (Address.class.isAssignableFrom(clazz))
			gen = addressGen();
		else
			throw new RuntimeException();

		return (DataGenerator<T>) gen;
	}

	private AddressDataGenerator addressGen(){
		return new AddressDataGenerator();
	}
}
