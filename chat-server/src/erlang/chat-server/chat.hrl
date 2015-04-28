%%%-------------------------------------------------------------------
%%% @author dedda
%%% @copyright (C) 2015, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 28. Apr 2015 15:24
%%%-------------------------------------------------------------------
-author("dedda").
-record(user, {id, username, email, experience}).
-record(message, {src_id, target_id, timestamp, contents}).
-record(login, {user_id, password}).
