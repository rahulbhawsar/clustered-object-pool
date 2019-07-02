package org.bbottema.clusteredobjectpool.cyclingstrategies;

import org.bbottema.clusteredobjectpool.core.api.LoadBalancingStrategy;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Evenly cycles through the given items.
 */
@SuppressWarnings("unused")
public class RoundRobinLoadBalancing implements LoadBalancingStrategy<Queue> {
	
	@NotNull
	@Override
	public Queue createCollectionForCycling() {
		return new LinkedList<>();
	}
	
	@NotNull
	@Override
	public <T> T cycle(@NotNull Queue items) {
		@SuppressWarnings("unchecked") Queue<T> itemsType = items;
		T nextItem = itemsType.remove();
		itemsType.add(nextItem);
		return nextItem;
	}
}