package com.shvet.network;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MessageDao_Impl implements MessageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TableMessage> __insertionAdapterOfTableMessage;

  public MessageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTableMessage = new EntityInsertionAdapter<TableMessage>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `message_table` (`id`,`from`,`to`,`text`,`image`,`time`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TableMessage value) {
        stmt.bindLong(1, value.getId());
        if (value.getFrom() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFrom());
        }
        if (value.getTo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTo());
        }
        if (value.getText() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getText());
        }
        final int _tmp = value.getImage() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindLong(6, value.getTime());
      }
    };
  }

  @Override
  public void insertMessages(final TableMessage... messages) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTableMessage.insert(messages);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<TableMessage> getAll() {
    final String _sql = "SELECT * FROM message_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "from");
      final int _cursorIndexOfTo = CursorUtil.getColumnIndexOrThrow(_cursor, "to");
      final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final List<TableMessage> _result = new ArrayList<TableMessage>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TableMessage _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpFrom;
        if (_cursor.isNull(_cursorIndexOfFrom)) {
          _tmpFrom = null;
        } else {
          _tmpFrom = _cursor.getString(_cursorIndexOfFrom);
        }
        final String _tmpTo;
        if (_cursor.isNull(_cursorIndexOfTo)) {
          _tmpTo = null;
        } else {
          _tmpTo = _cursor.getString(_cursorIndexOfTo);
        }
        final String _tmpText;
        if (_cursor.isNull(_cursorIndexOfText)) {
          _tmpText = null;
        } else {
          _tmpText = _cursor.getString(_cursorIndexOfText);
        }
        final boolean _tmpImage;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfImage);
        _tmpImage = _tmp != 0;
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        _item = new TableMessage(_tmpId,_tmpFrom,_tmpTo,_tmpText,_tmpImage,_tmpTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
