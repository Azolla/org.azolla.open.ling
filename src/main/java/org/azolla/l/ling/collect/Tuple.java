/*
 * @(#)Tuple.java		Created at 2013-5-2
 * 
 * Copyright (c) 2011-2013 azolla.org All rights reserved.
 * Azolla PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package org.azolla.l.ling.collect;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import javax.annotation.Nullable;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import org.azolla.l.ling.lang.Char0;

/**
 * Tuple
 * 
 * Quadruple&lt;Integer, Integer, Integer, Integer&gt; ip = Tuple.of(127, 0, 0, 1);
 * System.out.println(Tuple.joinWith(".").join(ip));	//127.0.0.1 
 *
 * @author 	sk@azolla.org
 * @since 	ADK1.0
 */
public class Tuple<First, Rest> implements Iterable<Object>
{
    public static final String BEGIN = String.valueOf(Char0.OPEN_PARENTHESIS);
    public static final String SEP   = String.valueOf(Char0.COMMA);
    public static final String END   = String.valueOf(Char0.CLOSE_PARENTHESIS);

    protected First first;
    protected Rest  rest;

    protected Tuple(First first, Rest rest)
    {
        this.first = first;
        this.rest = rest;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(Iterators.toArray(iterator(), Object.class));
    }

    @Override
    public boolean equals(@Nullable Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if ((null != obj) && (Tuple.class.isAssignableFrom(obj.getClass())))
        {
            return Iterables.elementsEqual(this, (Tuple<?, ?>) obj);
        }

        return false;
    }

    @Override
    public String toString()
    {
        return joinWith(BEGIN, SEP, END).join(this);
    }

    public String toString(String sep)
    {
        return toString(joinWith(sep));
    }

    public String toString(String begin, String sep, String end)
    {
        return toString(joinWith(begin, sep, end));
    }

    public String toString(TupleJoiner joiner)
    {
        return joiner.join(this);
    }

    public static TupleJoiner joinWith(String begin, String sep, String end)
    {
        return new TupleJoiner(begin, sep, end);
    }

    public static TupleJoiner joinWith(String sep)
    {
        return new TupleJoiner(BEGIN, sep, END);
    }

    @Override
    public Iterator<Object> iterator()
    {
        return Lists.newArrayList(first, rest).iterator();
    }

    public <T> Tuple<T, Tuple<First, Rest>> prepend(T t)
    {
        return new Tuple<T, Tuple<First, Rest>>(t, this);
    }

    public static Null of()
    {
        return new Null();
    }

    public static <T1> Single<T1> of(T1 t1)
    {
        return new Single<T1>(t1);
    }

    public static <T1, T2> Pair<T1, T2> of(T1 t1, T2 t2)
    {
        return new Pair<T1, T2>(t1, t2);
    }

    public static <T1, T2, T3> Triple<T1, T2, T3> of(T1 t1, T2 t2, T3 t3)
    {
        return new Triple<T1, T2, T3>(t1, t2, t3);
    }

    public static <T1, T2, T3, T4> Quadruple<T1, T2, T3, T4> of(T1 t1, T2 t2, T3 t3, T4 t4)
    {
        return new Quadruple<T1, T2, T3, T4>(t1, t2, t3, t4);
    }

    public static <T1, T2, T3, T4, T5> Quintuple<T1, T2, T3, T4, T5> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5)
    {
        return new Quintuple<T1, T2, T3, T4, T5>(t1, t2, t3, t4, t5);
    }

    public static <T1, T2, T3, T4, T5, T6> Sextuple<T1, T2, T3, T4, T5, T6> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6)
    {
        return new Sextuple<T1, T2, T3, T4, T5, T6>(t1, t2, t3, t4, t5, t6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Septuple<T1, T2, T3, T4, T5, T6, T7> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7)
    {
        return new Septuple<T1, T2, T3, T4, T5, T6, T7>(t1, t2, t3, t4, t5, t6, t7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Octuple<T1, T2, T3, T4, T5, T6, T7, T8> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8)
    {
        return new Octuple<T1, T2, T3, T4, T5, T6, T7, T8>(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Nonuple<T1, T2, T3, T4, T5, T6, T7, T8, T9> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9)
    {
        return new Nonuple<T1, T2, T3, T4, T5, T6, T7, T8, T9>(t1, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Decuple<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10)
    {
        return new Decuple<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> DecuplePlus<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, Object... rest)
    {
        return new DecuplePlus<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, rest);
    }

    public static <T1, Rest> T1 getFirst(Tuple<T1, Rest> tuple)
    {
        return tuple.first;
    }

    public static <T1, T2, Rest> T2 getSecond(Tuple<T1, Tuple<T2, Rest>> tuple)
    {
        return tuple.rest.first;
    }

    public static <T1, T2, T3, Rest> T3 getThird(Tuple<T1, Tuple<T2, Tuple<T3, Rest>>> tuple)
    {
        return tuple.rest.rest.first;
    }

    public static <T1, T2, T3, T4, Rest> T4 getFourth(Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Rest>>>> tuple)
    {
        return tuple.rest.rest.rest.first;
    }

    public static <T1, T2, T3, T4, T5, Rest> T5 getFifth(Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Rest>>>>> tuple)
    {
        return tuple.rest.rest.rest.rest.first;
    }

    public static <T1, T2, T3, T4, T5, T6, Rest> T6 getSixth(Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Rest>>>>>> tuple)
    {
        return tuple.rest.rest.rest.rest.rest.first;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, Rest> T7 getSeventh(Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple<T7, Rest>>>>>>> tuple)
    {
        return tuple.rest.rest.rest.rest.rest.rest.first;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, Rest> T8 getEighth(Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple<T7, Tuple<T8, Rest>>>>>>>> tuple)
    {
        return tuple.rest.rest.rest.rest.rest.rest.rest.first;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, Rest> T9 getNinth(Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple<T7, Tuple<T8, Tuple<T9, Rest>>>>>>>>> tuple)
    {
        return tuple.rest.rest.rest.rest.rest.rest.rest.rest.first;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, Rest> T10 getTenth(Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple<T7, Tuple<T8, Tuple<T9, Tuple<T10, Rest>>>>>>>>>> tuple)
    {
        return tuple.rest.rest.rest.rest.rest.rest.rest.rest.rest.first;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getN(Tuple<?, ?> tuple, int n)
    {
        return (T) Iterables.get(tuple, n);
    }

    private static enum End
    {
        SINGLETON;
    }

    public static class DecuplePlus<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple<T7, Tuple<T8, Tuple<T9, Tuple<T10, Tuple<Object[], End>>>>>>>>>>>
    {
        public DecuplePlus(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, Object[] rest)
        {
            super(t1, of(t2, t3, t4, t5, t6, t7, t8, t9, t10, rest));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Iterables.concat(Lists.newArrayList(new Object[] {first, rest.first, rest.rest.first, rest.rest.rest.first, rest.rest.rest.rest.first, rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.rest.rest.rest.first}), Lists.newArrayList(rest.rest.rest.rest.rest.rest.rest.rest.rest.rest.first)).iterator();
        }
    }

    public static class Decuple<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple<T7, Tuple<T8, Tuple<T9, Tuple<T10, End>>>>>>>>>>
    {
        public Decuple(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10)
        {
            super(t1, of(t2, t3, t4, t5, t6, t7, t8, t9, t10));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList(new Object[] {first, rest.first, rest.rest.first, rest.rest.rest.first, rest.rest.rest.rest.first, rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.rest.rest.rest.first}).iterator();
        }
    }

    public static class Nonuple<T1, T2, T3, T4, T5, T6, T7, T8, T9> extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple<T7, Tuple<T8, Tuple<T9, End>>>>>>>>>
    {
        public Nonuple(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9)
        {
            super(t1, of(t2, t3, t4, t5, t6, t7, t8, t9));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList(new Object[] {first, rest.first, rest.rest.first, rest.rest.rest.first, rest.rest.rest.rest.first, rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.rest.rest.first}).iterator();
        }
    }

    public static class Octuple<T1, T2, T3, T4, T5, T6, T7, T8> extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple<T7, Tuple<T8, End>>>>>>>>
    {
        public Octuple(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8)
        {
            super(t1, of(t2, t3, t4, t5, t6, t7, t8));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList(new Object[] {first, rest.first, rest.rest.first, rest.rest.rest.first, rest.rest.rest.rest.first, rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.rest.first}).iterator();
        }
    }

    public static class Septuple<T1, T2, T3, T4, T5, T6, T7> extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple<T7, End>>>>>>>
    {
        public Septuple(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7)
        {
            super(t1, of(t2, t3, t4, t5, t6, t7));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList(new Object[] {first, rest.first, rest.rest.first, rest.rest.rest.first, rest.rest.rest.rest.first, rest.rest.rest.rest.rest.first, rest.rest.rest.rest.rest.rest.first}).iterator();
        }
    }

    public static class Sextuple<T1, T2, T3, T4, T5, T6> extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, End>>>>>>
    {
        public Sextuple(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6)
        {
            super(t1, of(t2, t3, t4, t5, t6));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList(new Object[] {first, rest.first, rest.rest.first, rest.rest.rest.first, rest.rest.rest.rest.first, rest.rest.rest.rest.rest.first}).iterator();
        }
    }

    public static class Quintuple<T1, T2, T3, T4, T5> extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, End>>>>>
    {
        public Quintuple(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5)
        {
            super(t1, of(t2, t3, t4, t5));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList(new Object[] {first, rest.first, rest.rest.first, rest.rest.rest.first, rest.rest.rest.rest.first}).iterator();
        }
    }

    public static class Quadruple<T1, T2, T3, T4> extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, End>>>>
    {
        public Quadruple(T1 t1, T2 t2, T3 t3, T4 t4)
        {
            super(t1, of(t2, t3, t4));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList(new Object[] {first, rest.first, rest.rest.first, rest.rest.rest.first}).iterator();
        }
    }

    public static class Triple<T1, T2, T3> extends Tuple<T1, Tuple<T2, Tuple<T3, End>>>
    {
        public Triple(T1 t1, T2 t2, T3 t3)
        {
            super(t1, of(t2, t3));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList(new Object[] {first, rest.first, rest.rest.first}).iterator();
        }
    }

    public static class Pair<T1, T2> extends Tuple<T1, Tuple<T2, End>>
    {
        public Pair(T1 t1, T2 t2)
        {
            super(t1, of(t2));
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList(new Object[] {first, rest.first}).iterator();
        }
    }

    public static class Single<T1> extends Tuple<T1, End>
    {
        public Single(T1 t1)
        {
            super(t1, End.SINGLETON);
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Lists.newArrayList((Object) first).iterator();
        }
    }

    public static class Null extends Tuple<End, End>
    {
        private Null()
        {
            super(End.SINGLETON, End.SINGLETON);
        }

        @Override
        public Iterator<Object> iterator()
        {
            return Collections.emptyIterator();
        }
    }

    public static class TupleJoiner
    {
        private final String open;
        private final String separator;
        private final String close;

        public TupleJoiner(String open, String separator, String close)
        {
            this.open = open;
            this.separator = separator;
            this.close = close;
        }

        public <A extends Appendable> A appendTo(A appender, Tuple<?, ?> tuple) throws IOException
        {
            appender.append(open);
            Iterator<Object> iterTerm = tuple.iterator();
            if(iterTerm.hasNext())
            {
                appender.append(toString(iterTerm.next()));
                while(iterTerm.hasNext())
                {
                    appender.append(separator);
                    appender.append(toString(iterTerm.next()));
                }
            }
            appender.append(close);

            return appender;
        }

        public StringBuilder appendTo(StringBuilder builder, Tuple<?, ?> tuple)
        {
            try
            {
                appendTo((Appendable) builder, tuple);
            }
            catch(IOException impossible)
            {
                throw new AssertionError(impossible);
            }

            return builder;
        }

        public StringBuilder appendTo(Tuple<?, ?> tuple)
        {
            return appendTo(new StringBuilder(), tuple);
        }

        public String join(Tuple<?, ?> tuple)
        {
            return appendTo(tuple).toString();
        }

        private CharSequence toString(Object term)
        {
            return (term instanceof CharSequence) ? (CharSequence) term : String.valueOf(term);
        }
    }
}
