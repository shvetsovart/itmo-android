package com.shvet.messenger;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MessagesDao_Impl implements MessagesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Channel> __insertionAdapterOfChannel;

  private final EntityInsertionAdapter<Entity> __insertionAdapterOfEntity;

  public MessagesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChannel = new EntityInsertionAdapter<Channel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Channels` (`name`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Channel value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
      }
    };
    this.__insertionAdapterOfEntity = new EntityInsertionAdapter<Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `AppDatabase` (`id`,`name`,`to`,`date`,`isText`,`text`,`imageLink`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entity value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getTo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTo());
        }
        stmt.bindLong(4, value.getDate());
        final int _tmp = value.isText() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        if (value.getText() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getText());
        }
        if (value.getImageLink() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImageLink());
        }
      }
    };
  }

  @Override
  public Object insertChannel(final Channel channel,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfChannel.insert(channel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insert(final Entity element, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEntity.insert(element);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getMessagesFromChannel(final String channel,
      final Continuation<? super List<Entity>> continuation) {
    final String _sql = "SELECT * FROM AppDatabase WHERE `to` = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (channel == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, channel);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Entity>>() {
      @Override
      public List<Entity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfTo = CursorUtil.getColumnIndexOrThrow(_cursor, "to");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsText = CursorUtil.getColumnIndexOrThrow(_cursor, "isText");
          final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
          final int _cursorIndexOfImageLink = CursorUtil.getColumnIndexOrThrow(_cursor, "imageLink");
          final List<Entity> _result = new ArrayList<Entity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Entity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpTo;
            if (_cursor.isNull(_cursorIndexOfTo)) {
              _tmpTo = null;
            } else {
              _tmpTo = _cursor.getString(_cursorIndexOfTo);
            }
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final boolean _tmpIsText;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsText);
            _tmpIsText = _tmp != 0;
            final String _tmpText;
            if (_cursor.isNull(_cursorIndexOfText)) {
              _tmpText = null;
            } else {
              _tmpText = _cursor.getString(_cursorIndexOfText);
            }
            final String _tmpImageLink;
            if (_cursor.isNull(_cursorIndexOfImageLink)) {
              _tmpImageLink = null;
            } else {
              _tmpImageLink = _cursor.getString(_cursorIndexOfImageLink);
            }
            _item = new Entity(_tmpId,_tmpName,_tmpTo,_tmpDate,_tmpIsText,_tmpText,_tmpImageLink);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllChannels(final Continuation<? super List<String>> continuation) {
    final String _sql = "SELECT * FROM Channels";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
