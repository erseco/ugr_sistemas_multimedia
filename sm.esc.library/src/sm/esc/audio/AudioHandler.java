/*
 *  Copyright (C) 2016 Ernesto Serrano <info at ernesto.es>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package sm.esc.audio;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 *
 * @author Ernesto Serrano
 */
public class AudioHandler implements LineListener
{

    @Override
    public void update(LineEvent event)
    {
        if (event.getType() == LineEvent.Type.START)
        {
            //TODO
        }
        if (event.getType() == LineEvent.Type.STOP)
        {
            //TODO
        }
        if (event.getType() == LineEvent.Type.CLOSE)
        {
            //TODO
        }
    }

}
