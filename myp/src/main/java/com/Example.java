package com;

import java.util.Collection;

public interface Example {

	<T extends Comparable<? super T>> T max(Collection<? extends T> col);

}
