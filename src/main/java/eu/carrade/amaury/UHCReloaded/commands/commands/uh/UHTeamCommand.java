/*
 * Copyright or © or Copr. Amaury Carrade (2014 - 2016)
 *
 * http://amaury.carrade.eu
 *
 * This software is governed by the CeCILL-B license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL-B
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-B license and that you accept its terms.
 */
package eu.carrade.amaury.UHCReloaded.commands.commands.uh;

import eu.carrade.amaury.UHCReloaded.UHCReloaded;
import eu.carrade.amaury.UHCReloaded.commands.commands.categories.Category;
import eu.carrade.amaury.UHCReloaded.commands.commands.uh.team.UHTeamAddCommand;
import eu.carrade.amaury.UHCReloaded.commands.commands.uh.team.UHTeamGUICommand;
import eu.carrade.amaury.UHCReloaded.commands.commands.uh.team.UHTeamJoinCommand;
import eu.carrade.amaury.UHCReloaded.commands.commands.uh.team.UHTeamLeaveCommand;
import eu.carrade.amaury.UHCReloaded.commands.commands.uh.team.UHTeamListCommand;
import eu.carrade.amaury.UHCReloaded.commands.commands.uh.team.UHTeamRemoveCommand;
import eu.carrade.amaury.UHCReloaded.commands.commands.uh.team.UHTeamResetCommand;
import eu.carrade.amaury.UHCReloaded.commands.commands.uh.team.UHTeamSpyCommand;
import eu.carrade.amaury.UHCReloaded.commands.core.AbstractCommand;
import eu.carrade.amaury.UHCReloaded.commands.core.annotations.Command;
import eu.carrade.amaury.UHCReloaded.commands.core.exceptions.CannotExecuteCommandException;
import eu.carrade.amaury.UHCReloaded.i18n.I18n;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * This command is used to manage the teams.
 *
 * Usage: /uh team (for the doc).
 * Usage: /uh team <add|remove|join|leave|list|spy|reset> (see doc for details).
 */
@Command (name = "team")
public class UHTeamCommand extends AbstractCommand
{

    UHCReloaded p;
    I18n i;

    public UHTeamCommand(UHCReloaded plugin)
    {
        p = plugin;
        i = plugin.getI18n();

        registerSubCommand(new UHTeamAddCommand(p));
        registerSubCommand(new UHTeamRemoveCommand(p));
        registerSubCommand(new UHTeamJoinCommand(p));
        registerSubCommand(new UHTeamLeaveCommand(p));
        registerSubCommand(new UHTeamListCommand(p));
        registerSubCommand(new UHTeamSpyCommand(p));
        registerSubCommand(new UHTeamResetCommand(p));
        registerSubCommand(new UHTeamGUICommand(p));
    }

    /**
     * This will be executed if this command is called without argument,
     * or if there isn't any sub-command executor registered.
     *
     * @param sender The sender.
     * @param args   The arguments passed to the command.
     */
    @Override
    public void run(CommandSender sender, String[] args) throws CannotExecuteCommandException
    {
        throw new CannotExecuteCommandException(CannotExecuteCommandException.Reason.NEED_DOC, this);
    }

    /**
     * The result of this method will be added to the tab-complete suggestions for this command.
     *
     * @param sender The sender.
     * @param args   The arguments.
     *
     * @return The suggestions to add.
     */
    @Override
    public List<String> tabComplete(CommandSender sender, String[] args)
    {
        return null;
    }

    @Override
    public List<String> help(CommandSender sender)
    {
        return Arrays.asList(
                i.t("cmd.teamHelpTitle"),
                i.t("cmd.teamHelpJoinCmd"),
                i.t("cmd.teamHelpLeaveCmd")
        );
    }

    @Override
    public List<String> onListHelp(CommandSender sender)
    {
        return Collections.singletonList(i.t("cmd.helpTeam"));
    }

    @Override
    public String getCategory()
    {
        return Category.GAME.getTitle();
    }
}
