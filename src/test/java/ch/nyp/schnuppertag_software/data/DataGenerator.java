package ch.nyp.schnuppertag_software.data;

public interface DataGenerator<T>
{
	DataHolder<T> generate();
}
