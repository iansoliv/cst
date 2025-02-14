/** *****************************************************************************
 * Copyright (c) 2012  DCA-FEEC-UNICAMP
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * Contributors:
 *     K. Raizer, A. L. O. Paraense, R. R. Gudwin - initial API and implementation
 ***************************************************************************** */
package br.unicamp.cst.core.entities;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * This class represents a Memory Container. The Memory Container is responsible
 * for implementing an important element in the Dynamic Subsumption mechanism
 * used in CST. All the Memory Objects in a Container are of the same type, and
 * hold the same parameters. The only differences among them are that they were
 * generated by a different codelet, and they might have different evaluations.
 * An evaluation is an inner parameter from any Memory Object, which holds a
 * value (usually a real value between 0 and 1) that measures a relative
 * importance given by the codelet, and which is used by the Evaluation codelet
 * within the Container to decide which from all input Memory Objects will be
 * sent to the output.
 *
 * @author A. L. O. Paraense
 * @see Memory
 * @see MemoryObject
 */
public class MemoryContainer implements Memory {

	private volatile ArrayList<Memory> memories;

	/**
	 * Type of the memory container
	 */
	private String name;

	/**
	 * Creates a MemoryContainer as 
	 * an ArrayList of Memory objects.
	 * 
	 * Memory is an interface.
	 */
	public MemoryContainer()
	{
		memories = new ArrayList<>();
	}

	/**
	 * Creates a MemoryContainer.
	 *
	 * @param type the type of the memories inside the container.
	 */
	public MemoryContainer( String type )
	{
		this();				// call the parameterless constructor, and

		this.name = type;		// set the allowed memory type.
	}

	/**
	 * Sets the type of the memories inside the container.
	 *
	 * @param name the type of the memories inside the container.
	 */
	public synchronized void setType( String name )
	{
		this.name = name;
	}

	/**
	 * Gets the info of the memory with the highest evaluation value.
	 *
	 * @return the info I of the memory which has the highest evaluation.
	 */
	@Override
	public synchronized Object getI()
	{
		Object I = null;

		double maxEval = 0.0d;

		for (Memory memory : memories)
		{
			double memoryEval = memory.getEvaluation();

			if (memoryEval >= maxEval)
			{
				maxEval = memoryEval;
				I = memory.getI();
			}
		}

		return I;
	}

	/**
	 * Gets the info of the memory which has the index passed.
	 *
	 * @param index the index of the memory whose info is searched.
	 * @return the info of the memory which has the index passe or null is not
	 * found.
	 */
	public synchronized Object getI( int index )
	{
		if (index >= 0 && index < memories.size())
		{
			return ( memories.get( index ).getI() );
		}
		else
		{
			System.out.println( "Index for the " + getName()
					+ ".getI(index) method greater than the number of MemoryObjects within the MemoryContainer" );
			return ( null );
		}
	}

	/**
	 * Gets the info of the memory filtered by the predicate.
	 *
	 * @param predicate the predicate to be used to filter the stream.
	 * @return the info of the memory or null if not found.
	 */
	public synchronized Object getI( Predicate<Memory> predicate )
	{

		Object object = null;

		if (memories != null && memories.size() > 0)
		{
			Optional<Memory> optional = memories.stream().filter( predicate ).findFirst();

			if (optional.isPresent())
			{	// Check whether optional has 
				// the element for which the user is looking..

				Memory memory = optional.get();// get it from optional
				object = memory.getI();
			}
		}

		return object;

	}

	/**
	 * Gets the info of the memory reduced by the binary operator passed.
	 *
	 * @param accumulator the binary operator.
	 * @return the info of the memory or null if not found.
	 */
	public synchronized Object getI( BinaryOperator<Memory> accumulator )
	{
		Object object = null;

		if (memories != null && memories.size() > 0)
		{
			Optional<Memory> optional = memories.stream().reduce( accumulator );

			if (optional.isPresent())
			{// Check whether optional has element you
				// are looking for

				Memory memory = optional.get();// get it from optional
				object = memory.getI();
			}
		}

		return object;

	}

	/**
	 * MemoryContainer inserts the info as 
	 * a new MemoryObject in its Memory list.
	 */
	@Override
	public synchronized int setI( Object info )
	{
		return setI( info, -1.0d );
	}

	/**
	 * Creates a Memory Object with the info and the evaluation passed.
	 *
	 * @param info the info of the new Memory Object.
	 * @param evaluation the evaluation of the new Memory Object.
	 * @return the index of the new Memory Object.
	 */
	public synchronized int setI( Object info, Double evaluation )
	{
		MemoryObject mo = new MemoryObject();
		mo.setI( info );
		if (evaluation != -1.0)
		{
			mo.setEvaluation( evaluation );
		}
		mo.setType( "" );

		memories.add( mo );

		return memories.indexOf( mo );

	}

	/**
	 * Sets the info of the Memory with the index passed.
	 *
	 * @param info the information to be set in the
	 * @param index the index of the memory inside the container.
	 */
	public synchronized void setI( Object info, int index )
	{
		if (memories != null && memories.size() > index)
		{
			Memory memory = memories.get( index );

			if (memory != null)
			{
				if (memory instanceof MemoryObject)
				{
					memory.setI( info );
				}
				else if (memory instanceof MemoryContainer)
				{
					( (MemoryContainer) memory ).setI( info, index );
				}
			}
		}

	}

	/**
	 * Sets the info and the evaluation of the memory with the index passed
	 * inside this container.
	 *
	 * @param info the information to be set in the.
	 * @param index the index of the memory inside this container.
	 * @param evaluation the evaluation to be set.
	 */
	public synchronized void setI( Object info, Double evaluation, int index )
	{
		if (memories != null && memories.size() > index)
		{
			Memory memory = memories.get( index );

			if (memory != null)
			{
				if (memory instanceof MemoryObject)
				{
					memory.setI( info );
					memory.setEvaluation( evaluation );
				}
				else if (memory instanceof MemoryContainer)
				{
					// set the data of all the objects contained in MemoryContainer.
					//TODO : Bug ?
					( (MemoryContainer) memory ).setI( info, evaluation, index );
				}
			}
		}

	}
	
	/**
	 * Sets the Java String info as the info and an evaluation passed to a
	 * Memory of the type passed.
	 *
	 * @param info Java String info.
	 * @param evaluation the evaluation to set.
	 * @param type the type of the Memory
	 * @return the index of the memory
	 */
	public synchronized int setI( String info, double evaluation, String type )
	{
		return setI( (Object) info, evaluation, type);
	}

	/**
	 * Sets the info as the info and an evaluation passed to a Memory of the
	 * type passed.
	 *
	 * @param info the info.
	 * @param evaluation the evaluation to set.
	 * @param type the type of the Memory
	 * @return the index of the memory
	 */
	public synchronized int setI( Object info, double evaluation, String type )
	{
		int index = -1;

		if (memories != null)
		{
			boolean set = false;

			for (int i = 0; i < memories.size(); i++)
			{
				Memory memory = memories.get( i );

				if (memory != null && memory instanceof MemoryObject)
				{
					MemoryObject memoryObject = (MemoryObject) memory;

					if (memoryObject.getName().equalsIgnoreCase( type ))
					{
						memory.setI( info );
						memory.setEvaluation( evaluation );
						index = i;
						set = true;
						break;
					}
				}
			}

			if (!set)
			{
				MemoryObject mo = new MemoryObject();
				mo.setI( info );
				mo.setEvaluation( evaluation );
				mo.setType( type );

				memories.add( mo );

				index = memories.indexOf( mo );
			}
		}

		return index;
	}

	/**
	 * Gets the greatest evaluation of the memories in the memory list.
	 *
	 * @return the greatest evaluation of the memories in the memory list.
	 */
	@Override
	public synchronized Double getEvaluation()
	{
		Double maxEvaluation = 0.0d;

		for (Memory memory : memories)
		{
			double memoryEval = memory.getEvaluation();

			if (memoryEval >= maxEvaluation)
			{
				maxEvaluation = memoryEval;
			}
		}

		return maxEvaluation;
	}

	/**
	 * Gets the type of the memory which has the greatest evaluation.
	 *
	 * @return the type of the memory which has the greatest evaluation.
	 */
	@Override
	public synchronized String getName()
	{
		return name;
	}

	@Override
	public synchronized void setEvaluation( Double eval )
	{
		throw new UnsupportedOperationException(
				"This method is not available for MemoryContainer. Use setEvaluation(Double eval, int index) instead" );
	}

	/**
	 * Sets the evaluation of the memory with the index passed inside this
	 * container.
	 *
	 * @param eval the evaluation to set.
	 * @param index the index of the memory inside this container.
	 */
	public synchronized void setEvaluation( Double eval, int index )
	{
		if (memories != null && memories.size() > index)
		{
			Memory memory = memories.get( index );

			if (memory != null)
			{
				if (memory instanceof MemoryObject)
				{
					memory.setEvaluation( eval );
				}
				else if (memory instanceof MemoryContainer)
				{
					( (MemoryContainer) memory ).setEvaluation( eval, index );
				}
			}
		}

	}

	/**
	 * Adds a memory to this container.
	 *
	 * @param memory the memory to be added in this container
	 *
	 * @return the index of the input memory, if it succeeds in inserting it into the memory. 
	 * Otherwise, returns -1.
	 */
	public synchronized int add( Memory memory )
	{
		int index = -1;

		if (memory != null)
		{
			memories.add( memory );

			index = memories.indexOf( memory );
		}

		return index;
	}

	

	/**
	 * Gets all the memories inside this container.
	 *
	 * @return all the memories inside this container.
	 */
	public synchronized ArrayList<Memory> getAllMemories()
	{
		return memories;
	}

}
