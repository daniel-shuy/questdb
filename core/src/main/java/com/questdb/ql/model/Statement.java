/*******************************************************************************
 *    ___                  _   ____  ____
 *   / _ \ _   _  ___  ___| |_|  _ \| __ )
 *  | | | | | | |/ _ \/ __| __| | | |  _ \
 *  | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *   \__\_\\__,_|\___||___/\__|____/|____/
 *
 * Copyright (C) 2014-2016 Appsicle
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 ******************************************************************************/

package com.questdb.ql.model;

public class Statement {
    public static final int CREATE = 1;
    public static final int QUERY = 2;
    public static final int CREATE_AS = 3;

    private final int type;
    private final Object model;

    public Statement(int statementType, Object model) {
        this.type = statementType;
        this.model = model;
    }


    @SuppressWarnings("unchecked")
    public <T> T as(Class<T> clazz) {
        if (clazz.isAssignableFrom(model.getClass())) {
            return (T) model;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getType() {
        return type;
    }
}
