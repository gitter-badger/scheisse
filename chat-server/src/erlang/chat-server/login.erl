%%%-------------------------------------------------------------------
%%% @author dedda
%%% @copyright (C) 2015, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 28. Apr 2015 15:35
%%%-------------------------------------------------------------------
-module(login).
-author("dedda").
-include("chat.hrl").

%% API
-export([login/1, login/2, logout/1, is_logged_in/1]).

login(Login) when is_record(Login, login) ->
  Userid = Login#login.user_id,
  Password = Login#login.password,
  login(Userid, Password);
login(_) ->
  false.

login(Id, Password) when is_integer(Id) ->
  %%% TODO: implement
  false;
login(_, _) ->
  false.

logout(User) when is_record(User, user) ->
  logout(User#user.id);
logout(Userid) when is_integer(Userid) ->
  %%% TODO: implement
  false;
logout(_) ->
  false.

is_logged_in(User) when is_record(User, user) ->
  is_logged_in(User#user.id);
is_logged_in(Userid) when is_integer(Userid) ->
  %%% TODO: implement
  false;
is_logged_in(_) ->
  false.
