package nse.skbh.springboot.logic;

import java.util.Comparator;

import nse.skbh.springboot.pojo.Nse;

public class CompratorClass implements Comparator<Nse> {

	@Override
	public int compare(Nse o1, Nse o2) {
		if (o1.getUsedLimit() > o2.getUsedLimit())
			return 1;
		else if (o1.getUsedLimit() < o2.getUsedLimit())
			return -1;
		else
			return 0;
	}

}
